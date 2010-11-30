package glslplugin.annotation.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import glslplugin.annotation.Annotator;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.statements.ConditionStatement;
import glslplugin.lang.elements.statements.GLSLStatement;
import glslplugin.lang.elements.statements.GLSLWhileStatement;
import glslplugin.lang.elements.types.GLSLPrimitiveType;
import glslplugin.lang.elements.types.GLSLType;

/**
 * Copyright (c) 2009 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 09.mar.2009
 * Time: 22:24:33
 */
public class ConditionCheckAnnotation implements Annotator<GLSLStatement> {
    public void annotate(GLSLStatement expr, AnnotationHolder holder) {

        if (expr instanceof ConditionStatement) {
            ConditionStatement conditionStatement = (ConditionStatement) expr;
            GLSLExpression condition = conditionStatement.getConditionExpression();

            if (condition != null) {
                GLSLType conditionType = condition.getType();
                if (conditionType instanceof GLSLPrimitiveType) {
                    GLSLPrimitiveType pType = (GLSLPrimitiveType) conditionType;
                    if (!pType.equals(GLSLPrimitiveType.BOOL)) {
                        holder.createErrorAnnotation(condition, "Condition must be a boolean expression.");
                    }
                }
            } else if (expr instanceof GLSLWhileStatement){
                //todo: get declaration from while statement
            }
        }


    }
}
