package glslplugin.lang.elements.types;

import glslplugin.lang.elements.declarations.GLSLArraySpecifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * NewArrayTypeImpl is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 6, 2009
 *         Time: 11:57:22 PM
 */
public class GLSLArrayType extends GLSLType {
    private GLSLType baseType;
    private GLSLArraySpecifier arraySpecifier;
    private Map<String, GLSLFunctionType> methods = new HashMap<String, GLSLFunctionType>();

    public GLSLArrayType(@NotNull GLSLType baseType, GLSLArraySpecifier arraySpecifier) {
        this.baseType = baseType;
        this.arraySpecifier = arraySpecifier;
        this.methods.put("length", new GLSLBasicFunctionType("length", baseType));
    }

    @Override
    @NotNull
    public GLSLType getBaseType() {
        return baseType;
    }

    @NotNull
    public String getTypename() {
        return baseType.getTypename() + "[]";
    }

    @Override
    public GLSLArraySpecifier getArraySpecifier() {
        return arraySpecifier;
    }

    @Override
    public Map<String, GLSLFunctionType> getMethods() {
        return methods;
    }
}
