package glslplugin.lang.elements.types;

import glslplugin.lang.elements.GLSLElement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * GLSLFunctionType is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 4, 2009
 *         Time: 6:47:33 PM
 */
public abstract class GLSLFunctionType extends GLSLType {
    public static final GLSLFunctionType[] EMPTY_ARRAY = {};
    protected final GLSLType returnType;
    protected String typename;
    @NotNull
    private String name;
    GLSLElement definition;

    protected GLSLFunctionType(@NotNull String name, GLSLType returnType) {
        this.returnType = returnType;
        this.name = name;
    }

    @NotNull
    public String getName() {
        return name;
    }

    protected abstract String generateTypename();

    public String getTypename() {
        if (typename == null) {
            typename = generateTypename();
        }
        return typename;
    }

    @Override
    public GLSLType getBaseType() {
        return returnType;
    }

    @Override
    public GLSLElement getDefinition() {
        return definition;
    }

    @NotNull
    public abstract GLSLTypeCompatibilityLevel getParameterCompatibilityLevel(@NotNull GLSLType[] types);

    /**
     * Filters a list of function-type alternatives to the set of types matching the parameter types.
     *
     * @param alternatives   the alternatives to filter
     * @param parameterTypes the parameter-types to match
     * @return the alternatives which is applicable to parameterTypes
     */
    public static GLSLFunctionType[] findApplicableTypes(GLSLFunctionType[] alternatives, GLSLType[] parameterTypes) {
        List<GLSLFunctionType> filteredAlternatives = new ArrayList<GLSLFunctionType>(alternatives.length);
        for (GLSLFunctionType alternative : alternatives) {
            GLSLTypeCompatibilityLevel compatibility = alternative.getParameterCompatibilityLevel(parameterTypes);
            switch (compatibility) {
                case COMPATIBLE_WITH_IMPLICIT_CONVERSION:
                    filteredAlternatives.add(alternative);
                    break;

                case DIRECTLY_COMPATIBLE:
                    return new GLSLFunctionType[]{alternative};

                case INCOMPATIBLE:
                    // do nothing
                    break;
            }
        }
        return filteredAlternatives.toArray(new GLSLFunctionType[filteredAlternatives.size()]);
    }
}
