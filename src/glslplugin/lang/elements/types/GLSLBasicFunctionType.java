package glslplugin.lang.elements.types;

import glslplugin.lang.elements.declarations.GLSLDeclarator;
import glslplugin.lang.elements.declarations.GLSLFunctionDeclaration;
import glslplugin.lang.elements.declarations.GLSLParameterDeclaration;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLFunctionType is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 2, 2009
 *         Time: 12:20:32 PM
 */
public class GLSLBasicFunctionType extends GLSLFunctionType {
    public static final GLSLFunctionType[] EMPTY_ARRAY = {};

    private final GLSLType[] parameterTypes;

    public GLSLBasicFunctionType(GLSLFunctionDeclaration declaration) {
        super(declaration.getDeclaredName(), declaration.getTypeSpecifierNode().getType());
        final GLSLParameterDeclaration[] parameterDeclarations = declaration.getParameters();
        definition = declaration;

        parameterTypes = new GLSLType[parameterDeclarations.length];
        for (int i = 0; i < parameterDeclarations.length; i++) {
            GLSLDeclarator declarator = parameterDeclarations[i].getDeclarator();
            parameterTypes[i] = declarator.getType();
        }

        this.typename = generateTypename();
    }

    public GLSLBasicFunctionType(@NotNull String name, @NotNull GLSLType type, @NotNull GLSLType... parameterTypes) {
        super(name, type);
        this.parameterTypes = parameterTypes;
        this.typename = generateTypename();
    }

    protected String generateTypename() {
        StringBuilder b = new StringBuilder();
        b.append('(');
        boolean first = true;
        for (GLSLType type : parameterTypes) {
            if (!first) {
                b.append(',');
            }
            first = false;
            b.append(type.getTypename());
        }
        b.append(") : ").append(getBaseType().getTypename());
        return b.toString();
    }

    @NotNull
    public GLSLTypeCompatibilityLevel getParameterCompatibilityLevel(@NotNull GLSLType[] types) {
        return GLSLTypeCompatibilityLevel.getCompatibilityLevel(types, parameterTypes);
    }

    @NotNull
    public GLSLType[] getParameterTypes() {
        return parameterTypes;
    }
}
