package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.tree.IElementType;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLTokenTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * NewDeclarationList is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 29, 2009
 *         Time: 4:59:57 PM
 */
public class GLSLDeclarationList extends GLSLElementImpl {
    public GLSLDeclarationList(ASTNode node) {
        super(node);
    }

    public GLSLDeclaration[] getDeclarations() {
        // convert the list of children to a list of GLSLStatement objects while performing sanity check.
        PsiElement[] children = getChildren();
        List<GLSLDeclaration> result = new ArrayList<GLSLDeclaration>(children.length);
        for (PsiElement child : children) {
            if (child instanceof GLSLDeclaration) {
                result.add((GLSLDeclaration) child);
            } else if (!(child instanceof PsiErrorElement)) {
                final ASTNode node = child.getNode();
                if (node != null) {
                    final IElementType type = node.getElementType();
                    if (!GLSLTokenTypes.COMMENTS.contains(type)) {
                        throw new RuntimeException("Parameter declaration list contains non-comment, non-expression element.");
                    }
                }
            }
        }
        return result.toArray(new GLSLDeclaration[result.size()]);
    }

    public GLSLDeclaration getLastDeclaration() {
        GLSLDeclaration[] declarations = getDeclarations();
        return declarations[declarations.length - 1];
    }

    public GLSLDeclaration getFirstDeclaration() {
        GLSLDeclaration[] declarations = getDeclarations();
        return declarations[0];
    }

    @Override
    public String toString() {
        return "Declaration List (" + getDeclarations().length + " parameters)";
    }
}
