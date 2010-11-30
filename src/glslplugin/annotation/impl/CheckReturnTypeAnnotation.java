package glslplugin.annotation.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotation;
import com.intellij.psi.PsiElement;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import glslplugin.annotation.Annotator;
import glslplugin.lang.elements.statements.*;
import glslplugin.lang.elements.GLSLElement;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.declarations.GLSLFunctionDefinitionImpl;
import glslplugin.lang.elements.declarations.GLSLFunctionDefinition;

import java.awt.*;

/**
 * First half of function return type checking.
 * todo: Must have a separate annotation to check if a function with a return type has a return statement.
 *
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-03-05 15:33
 */
public class CheckReturnTypeAnnotation implements Annotator<GLSLStatement> {

    public void annotate(GLSLStatement expr, AnnotationHolder holder) {
        if (expr instanceof GLSLReturnStatement) {
            GLSLFunctionDefinition function = expr.findParentByClass(GLSLFunctionDefinition.class);

            if(function != null) {
                GLSLType functionType = function.getTypeSpecifierNode().getType();
                GLSLType returnType = ((GLSLReturnStatement) expr).getReturnType();

                if(!returnType.isValidType() || !functionType.isConvertibleTo(returnType)) {
                    holder.createErrorAnnotation(expr, "Incompatible types. Required: " + functionType.getTypename() + ", found: " + returnType.getTypename());
                }
            }
        }
    }
}