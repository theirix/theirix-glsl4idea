package glslplugin.annotation.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import glslplugin.annotation.Annotator;
import glslplugin.lang.elements.expressions.GLSLAssignmentExpression;
import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * LValueAnnotation checks for l-values at the left hand side of assignment expressions.
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 30, 2009
 *         Time: 10:46:40 AM
 */
public class LValueAnnotator implements Annotator<GLSLAssignmentExpression> {

    public void annotate(GLSLAssignmentExpression expr, AnnotationHolder holder) {
        GLSLExpression left = expr.getLeftOperand();
        if (!left.isLValue()) {
            holder.createErrorAnnotation(left, "Left operand of assignment expression is not L-Value.");
        }
    }
}
