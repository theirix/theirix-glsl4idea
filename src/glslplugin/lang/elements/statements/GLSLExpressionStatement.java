package glslplugin.lang.elements.statements;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * GLSLExpressionStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 5:53:38 PM
 */
public class GLSLExpressionStatement extends GLSLStatement {
    public GLSLExpressionStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getExpression() {
        GLSLExpression expr = findChildByClass(GLSLExpression.class);
        if (expr != null) {
            return expr;
        } else {
            throw new RuntimeException("Expression statement with no expression!");
        }
    }

    public String toString() {
        return "Expression Statement";
    }
}
