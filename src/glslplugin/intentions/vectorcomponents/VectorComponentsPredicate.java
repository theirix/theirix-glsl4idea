package glslplugin.intentions.vectorcomponents;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.GLSLIdentifier;
import glslplugin.lang.elements.expressions.GLSLFieldSelectionExpression;
import glslplugin.lang.elements.types.GLSLVectorType;

import java.util.regex.Pattern;

/**
 * Copyright (c) 2008. Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 26.jan.2009
 * Time: 12:48:54
 */
public class VectorComponentsPredicate {

    static final Pattern xyzw = Pattern.compile("^[xyzw]{1,4}$");
    static final Pattern rgba = Pattern.compile("^[rgba]{1,4}$");
    static final Pattern stpq = Pattern.compile("^[stpq]{1,4}$");

    public boolean satisfiedBy(PsiElement psiElement) {

        if (psiElement instanceof GLSLIdentifier) {
            ASTNode node = psiElement.getNode();
            if (node != null) {
                PsiElement parent = node.getTreeParent().getPsi();
                if (parent instanceof GLSLFieldSelectionExpression) {
                    GLSLIdentifier identifier = (GLSLIdentifier) psiElement;

                    GLSLFieldSelectionExpression fse = (GLSLFieldSelectionExpression) parent;
                    if (fse.getLeftHandExpression().getType() instanceof GLSLVectorType) {

                        String parameters = identifier.getIdentifierName();
                        if (checkForMatch(parameters)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean checkForMatch(String parameters) {
        return xyzw.matcher(parameters).matches() || rgba.matcher(parameters).matches() || stpq.matcher(parameters).matches();
    }
}
