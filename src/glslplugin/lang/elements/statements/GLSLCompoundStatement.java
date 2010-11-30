package glslplugin.lang.elements.statements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import glslplugin.lang.elements.GLSLTokenTypes;
import glslplugin.lang.elements.statements.GLSLStatement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * GLSLCompoundStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:00:00 PM
 */
public class GLSLCompoundStatement extends GLSLStatement {
    public GLSLCompoundStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLStatement[] getStatements() {
        // convert the list of children to a list of GLSLStatement objects while performing sanity check.
        PsiElement[] children = getChildren();
        List<GLSLStatement> result = new ArrayList<GLSLStatement>(children.length);
        for (PsiElement child : children) {
            if (child instanceof GLSLStatement) {
                result.add((GLSLStatement) child);
            } else {
                final ASTNode node = child.getNode();
                if (node != null) {
                    final IElementType type = node.getElementType();
                    if (!GLSLTokenTypes.COMMENTS.contains(type)) {
                        throw new RuntimeException("Compound statement contains non-comment, non-statement element.");
                    }
                }
            }
        }
        return result.toArray(new GLSLStatement[result.size()]);
    }

    public String toString() {
        return "Compound Statement (" + getStatements().length + " statements)";
    }
}
