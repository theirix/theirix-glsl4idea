package glslplugin.lang.elements;

import com.intellij.lang.ASTNode;

/**
 * GLSLPsiElementFactory defines the interface for the GLSLElement factory.
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 11:12:19 AM
 * @see GLSLPsiElementFactoryImpl
 */
public interface GLSLPsiElementFactory {
    /**
     * Creates a GLSLElement from the given ast node.
     *
     * @param node the source node.
     * @return the resulting GLSLElement, may be null.
     */
    public GLSLElement create(ASTNode node);
}
