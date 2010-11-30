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

import java.awt.*;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-03-05 15:33
 */
public class UnreachableAnnotation implements Annotator<GLSLStatement> {
    private TextAttributesKey strikeThrough;

    public UnreachableAnnotation() {
        TextAttributes textAttributes = new TextAttributes(Color.GRAY, null, Color.RED, EffectType.STRIKEOUT, Font.ITALIC);
        strikeThrough = TextAttributesKey.createTextAttributesKey("Unreachable", textAttributes);
    }

    public void annotate(GLSLStatement expr, AnnotationHolder holder) {
        //todo: not unreachables...
        if (expr instanceof GLSLBreakStatement || expr instanceof GLSLContinueStatement) {
            GLSLElement parent = expr.findParentByClasses(GLSLDoStatement.class, GLSLForStatement.class, GLSLWhileStatement.class);
            if(parent == null) {
                holder.createErrorAnnotation(expr, "Must be in a loop!");
                return;
            }
        }

        if (expr instanceof GLSLBreakStatement || expr instanceof GLSLContinueStatement || expr instanceof GLSLDiscardStatement || expr instanceof GLSLReturnStatement) {

            PsiElement element = expr.getNextSibling();
            while(element != null) {
                if(element instanceof GLSLElement) {
                    Annotation annotation = holder.createWarningAnnotation(element, "Unreachable expression");
                    annotation.setTextAttributes(strikeThrough);
                }

                element = element.getNextSibling();
            }

        }

    }
}
