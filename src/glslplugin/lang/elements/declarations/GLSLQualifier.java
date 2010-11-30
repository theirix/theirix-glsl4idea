package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLTokenTypes;
import glslplugin.lang.elements.types.GLSLTypeQualifier;
import org.jetbrains.annotations.NotNull;

/**
 * NewQualifier is all kinds of qualifiers combined into a single class.
 * <p/>
 * The qualifiers are associated with a qualifier type which are ordered by an integer value.
 * Qualifiers needs to appear in increasing order. Some storage qualifiers may be combined,
 * <code>varying centroid</code> in particular.
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 9:34:12 AM
 */
public class GLSLQualifier extends GLSLElementImpl {
    public static final GLSLQualifier[] EMPTY_ARRAY = {};


    public static enum Qualifier {
        // Invariant Qualifier
        INVARIANT(GLSLTypeQualifier.INVARIANT_QUALIFIER, "invariant", GLSLTokenTypes.INVARIANT_KEYWORD),

        // Storage Qualifiers
        CONST(GLSLTypeQualifier.STORAGE_QUALIFIER, "const", GLSLTokenTypes.CONST_KEYWORD),
        ATTRIBUTE(GLSLTypeQualifier.STORAGE_QUALIFIER, "attribute", GLSLTokenTypes.ATTRIBUTE_KEYWORD),
        UNIFORM(GLSLTypeQualifier.STORAGE_QUALIFIER, "uniform", GLSLTokenTypes.UNIFORM_KEYWORD),
        VARYING(GLSLTypeQualifier.STORAGE_QUALIFIER, "varying", GLSLTokenTypes.VARYING_KEYWORD),
        CENTROID(GLSLTypeQualifier.STORAGE_QUALIFIER, "centroid", GLSLTokenTypes.CENTROID_KEYWORD),

        // Parameter Qualifiers
        IN(GLSLTypeQualifier.PARAMETER_QUALIFIER, "in", GLSLTokenTypes.IN_KEYWORD),
        OUT(GLSLTypeQualifier.PARAMETER_QUALIFIER, "out", GLSLTokenTypes.OUT_KEYWORD),
        INOUT(GLSLTypeQualifier.PARAMETER_QUALIFIER, "inout", GLSLTokenTypes.INOUT_KEYWORD);
        private final GLSLTypeQualifier type;
        private final String textRepresentation;
        private final IElementType correspondingElement;

        Qualifier(GLSLTypeQualifier type, String textRepresentation, IElementType correspondingElement) {
            this.type = type;
            this.textRepresentation = textRepresentation;
            this.correspondingElement = correspondingElement;
        }

        GLSLTypeQualifier getType() {
            return type;
        }

        IElementType getCorrespondingElement() {
            return correspondingElement;
        }

        @Override
        public String toString() {
            return textRepresentation;
        }
    }


    public Qualifier getQualifier() {
        PsiElement qualifier = getFirstChild();
        assert qualifier != null;
        ASTNode qualifierNode = qualifier.getNode();
        assert qualifierNode != null;
        return getQualifierFromType(qualifierNode.getElementType());
    }

    public GLSLTypeQualifier getQualifierType() {
        return getQualifier().getType();
    }

    private Qualifier getQualifierFromType(IElementType elt) {
        for (Qualifier qualifier : Qualifier.values()) {
            if (qualifier.getCorrespondingElement() == elt) {
                return qualifier;
            }
        }
        throw new RuntimeException("Unsupported element type: " + elt);
    }

    public GLSLQualifier(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public String toString() {
        return "Qualifier: " + getQualifier();
    }
}
