package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypes;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLSubscriptExpression is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 30, 2009
 *         Time: 11:40:03 AM
 */
public class GLSLSubscriptExpression extends GLSLOperatorExpression {
    public GLSLSubscriptExpression(ASTNode node) {
        super(node);
    }

    public GLSLExpression getArrayExpression() {
        GLSLExpression[] operands = getOperands();
        if (operands.length == 2) {
            return operands[0];
        } else {
            throw new RuntimeException("Binary operator with " + operands.length + " operand(s).");
        }
    }

    public GLSLExpression getSubscriptExpression() {
        GLSLExpression[] operands = getOperands();
        if (operands.length == 2) {
            return operands[0];
        } else {
            throw new RuntimeException("Binary operator with " + operands.length + " operand(s).");
        }
    }

    @Override
    public boolean isLValue() {
        return getArrayExpression().isLValue();
    }

    @Override
    public String toString() {
        return "Subscript expression";
    }

    @NotNull
    @Override
    public GLSLType getType() {
        GLSLExpression left = getArrayExpression();
        GLSLType type = left.getType();
        if (type != GLSLTypes.UNKNOWN_TYPE) {
            if (type.isIndexable()) {
                return type.getBaseType();
            } else {
                return GLSLTypes.INVALID_TYPE;
            }
        }
        return GLSLTypes.UNKNOWN_TYPE;
    }
}
