package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * PostfixOperator is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 3:17:16 PM
 */
public class GLSLPostfixExpression extends GLSLOperatorExpression {
    public GLSLPostfixExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getOperand() {
        GLSLExpression[] operands = getOperands();
        if (operands.length != 1) {
            return operands[0];
        } else {
            throw new RuntimeException("Postfix operator with " + operands.length + " operand(s).");
        }
    }

    public String toString() {
        return "Postfix Operator '" + getOperator().getTextRepresentation() + "'";
    }
}
