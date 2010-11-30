package glslplugin.annotation.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import glslplugin.annotation.Annotator;
import glslplugin.lang.elements.expressions.GLSLFieldSelectionExpression;
import glslplugin.lang.elements.types.GLSLStructType;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.GLSLIdentifier;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-03-09 13:42
 */
public class MemberCheckAnnotation implements Annotator<GLSLFieldSelectionExpression> {
    public void annotate(GLSLFieldSelectionExpression expr, AnnotationHolder holder) {
        GLSLType leftHandType = expr.getLeftHandExpression().getType();

        if (leftHandType instanceof GLSLStructType) {
            GLSLIdentifier memberIdentifier = expr.getMemberIdentifier();
            GLSLType memberType = leftHandType.getMembers().get(memberIdentifier.getIdentifierName());
            if (memberType == null) {
                holder.createErrorAnnotation(memberIdentifier, "Unknown member for " + leftHandType.getTypename());
            }

        }

    }
}
