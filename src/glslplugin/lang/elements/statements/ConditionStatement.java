package glslplugin.lang.elements.statements;

import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-03-10 13:39
 */
public interface ConditionStatement {
    GLSLExpression getConditionExpression();
}
