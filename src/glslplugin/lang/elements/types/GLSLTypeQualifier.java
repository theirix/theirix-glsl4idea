package glslplugin.lang.elements.types;

/**
 * The qualifier types as specified in the spec.
 */
public enum GLSLTypeQualifier {
    INVARIANT_QUALIFIER(1, "invariant qualifier"),
    STORAGE_QUALIFIER(2, "storage qualifier"),
    PARAMETER_QUALIFIER(3, "parameter qualifier"),
    //reserved for futuer specs: PRECISION_QUALIFIER
    ;
    public final int order;
    private final String textRepresentation;

    GLSLTypeQualifier(int order, String textRepresentation) {
        this.order = order;
        this.textRepresentation = textRepresentation;
    }

    @Override
    public String toString() {
        return textRepresentation;
    }
}
