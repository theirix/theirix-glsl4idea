package glslplugin.annotation.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import glslplugin.annotation.Annotator;
import glslplugin.lang.elements.expressions.GLSLBinaryOperatorExpression;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.types.GLSLFunctionType;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypeCompatibilityLevel;

/**
 * BinaryOperatorTypeAnnotation is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 2, 2009
 *         Time: 11:38:57 AM
 */
public class BinaryOperatorTypeAnnotation implements Annotator<GLSLBinaryOperatorExpression> {

    public void annotate(GLSLBinaryOperatorExpression expr, AnnotationHolder holder) {
        final GLSLExpression left = expr.getLeftOperand();
        final GLSLExpression right = expr.getRightOperand();
        final GLSLType rightType = right.getType();
        final GLSLType leftType = left.getType();
        final GLSLFunctionType[] operatorAlternatives = expr.getOperatorTypeAlternatives();

        if (leftType.isValidType() && rightType.isValidType()) {
            boolean compatible = operatorAlternatives.length == 1;
            if (compatible) {
                compatible = operatorAlternatives[0].getParameterCompatibilityLevel(new GLSLType[]{leftType, rightType}) != GLSLTypeCompatibilityLevel.INCOMPATIBLE;
            }

            if (!compatible) {
                holder.createErrorAnnotation(expr, "Incompatible types as operands of '" + expr.getOperator().getTextRepresentation() + "': '"
                        + leftType.getTypename() + "' and '" + rightType.getTypename() + "'");
            }
        }
    }
}
