package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLSelectionExpressionBase is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 3, 2009
 *         Time: 12:47:56 PM
 */
public abstract class GLSLSelectionExpressionBase extends GLSLExpression {
    public GLSLSelectionExpressionBase(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getLeftHandExpression() {
        PsiElement first = getFirstChild();
        if (first instanceof GLSLExpression) {
            return (GLSLExpression) first;
        } else {
            throw new RuntimeException("Field selection operator missing postfix expression in front of '.'");
        }
    }
}
