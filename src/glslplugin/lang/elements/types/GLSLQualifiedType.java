package glslplugin.lang.elements.types;

import glslplugin.lang.elements.declarations.GLSLQualifier;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLQualifiedType is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 27, 2009
 *         Time: 11:19:10 AM
 */
public class GLSLQualifiedType {
    @NotNull
    private final GLSLType type;
    @NotNull
    private final GLSLTypeQualifier[] qualifiers;


    public GLSLQualifiedType(@NotNull GLSLType type, @NotNull GLSLTypeQualifier[] qualifiers) {
        this.type = type;
        this.qualifiers = qualifiers;
    }

    public GLSLQualifiedType(@NotNull GLSLType type, @NotNull glslplugin.lang.elements.declarations.GLSLQualifier[] qualifiers) {
        this.type = type;
        this.qualifiers = convertQualifiers(qualifiers);
    }

    @NotNull
    private GLSLTypeQualifier[] convertQualifiers(@NotNull GLSLQualifier[] qualifiers) {
        GLSLTypeQualifier[] result = new GLSLTypeQualifier[qualifiers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = qualifiers[i].getQualifierType();
        }
        return result;
    }

    @NotNull
    public GLSLType getType() {
        return type;
    }

    @NotNull
    public GLSLTypeQualifier[] getQualifiers() {
        return qualifiers;
    }
}
