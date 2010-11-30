package glslplugin.lang.elements.types;

import org.jetbrains.annotations.NotNull;

/**
 * TypeCompatibilityLevel is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 4, 2009
 *         Time: 12:48:15 PM
 */
public enum GLSLTypeCompatibilityLevel {
    INCOMPATIBLE,
    COMPATIBLE_WITH_IMPLICIT_CONVERSION,
    DIRECTLY_COMPATIBLE;

    @NotNull
    public static GLSLTypeCompatibilityLevel getCompatibilityLevel(@NotNull GLSLType source, @NotNull GLSLType target) {
        if (source.typeEquals(target)) {
            return DIRECTLY_COMPATIBLE;
        } else if (source.isConvertibleTo(target)) {
            return COMPATIBLE_WITH_IMPLICIT_CONVERSION;
        } else {
            return INCOMPATIBLE;
        }
    }

    @NotNull
    public static GLSLTypeCompatibilityLevel getCompatibilityLevel(@NotNull GLSLType[] source, @NotNull GLSLType[] target) {
        if (source.length != target.length) {
            return INCOMPATIBLE;
        }

        GLSLTypeCompatibilityLevel result = DIRECTLY_COMPATIBLE;

        for (int i = 0; i < source.length && result != INCOMPATIBLE; i++) {
            GLSLTypeCompatibilityLevel compatibility = getCompatibilityLevel(source[i], target[i]);
            switch (compatibility) {
                case COMPATIBLE_WITH_IMPLICIT_CONVERSION:
                    result = COMPATIBLE_WITH_IMPLICIT_CONVERSION;
                    break;

                case INCOMPATIBLE:
                    result = INCOMPATIBLE;
                    break;
            }
        }
        return result;
    }
}
