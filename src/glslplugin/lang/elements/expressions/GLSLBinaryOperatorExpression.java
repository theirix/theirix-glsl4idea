package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.types.GLSLFunctionType;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypes;
import org.jetbrains.annotations.NotNull;

/**
 * PostfixOperator is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 3:17:16 PM
 */
public class GLSLBinaryOperatorExpression extends GLSLOperatorExpression {
    public GLSLBinaryOperatorExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getLeftOperand() {
        GLSLExpression[] operands = getOperands();
        if (operands.length == 2) {
            return operands[0];
        } else {
            throw new RuntimeException("Binary operator with " + operands.length + " operand(s).");
        }
    }

    public GLSLExpression getRightOperand() {
        GLSLExpression[] operands = getOperands();
        if (operands.length == 2) {
            return operands[1];
        } else {
            throw new RuntimeException("Binary operator with " + operands.length + " operand(s).");
        }
    }


    public String toString() {
        return "Binary Operator: '" + getOperator().getTextRepresentation() + "'";
    }

    @NotNull
    @Override
    public GLSLType getType() {
        GLSLFunctionType[] alternatives = getOperatorTypeAlternatives();
        if (alternatives.length == 1) {
            return alternatives[0].getBaseType();
        } else {
            return GLSLTypes.UNKNOWN_TYPE;
        }

        /* TODO: REMOVE
        GLSLType leftType = getLeftOperand().getType();
        GLSLType rightType = getRightOperand().getType();

        if (leftType.isConvertibleTo(rightType)) {
            return rightType;
        } else if (rightType.isConvertibleTo(leftType)) {
            return leftType;
        } else {
            return GLSLTypes.UNKNOWN_TYPE;
        }
        */
    }

    public GLSLFunctionType[] getOperatorTypeAlternatives() {
        GLSLOperator operator = getOperator();
        GLSLType leftType = getLeftOperand().getType();
        GLSLType rightType = getRightOperand().getType();

        return operator.getFunctionTypeAlternatives(new GLSLType[]{leftType, rightType});
    }
}