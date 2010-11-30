package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * PostfixOperator is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 3:17:16 PM
 */
public class GLSLPrefixOperatorExpression extends GLSLOperatorExpression {
    public GLSLPrefixOperatorExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getOperand() {
        GLSLExpression[] operands = getOperands();
        if (operands.length != 1) {
            return operands[0];
        } else {
            throw new RuntimeException("Prefix operator with " + operands.length + " operand(s).");
        }
    }

    /**
     * Overrides the operator type to provide the unary versions of '+' and '-'.
     *
     * @param type the elements type to convert to an operator.
     * @return the resulting operator.
     */
    @Override
    protected GLSLOperator getOperatorFromType(IElementType type) {
        GLSLOperator op = super.getOperatorFromType(type);
        if (op == GLSLOperator.ADDITION) op = GLSLOperator.PLUS;
        if (op == GLSLOperator.SUBTRACTION) op = GLSLOperator.MINUS;
        return op;
    }

    public String toString() {
        return "Prefix Operator '" + getOperator().getTextRepresentation() + "'";
    }
}