package glslplugin.lang.elements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 14.sep.2008
 * Time: 17:34:44
 */
public class GLSLIdentifier extends GLSLElementImpl {

    public GLSLIdentifier(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public String getIdentifierName() {
        return getText();
    }

    public String toString() {
        return "Identifier: '" + getText() + "'";
    }

    private GLSLReferenceElement getRealReference() {
        PsiElement parent = getParent();
        if (parent instanceof GLSLReferenceElement) {
            return (GLSLReferenceElement) parent;
        } else {
            return null;
        }
    }

    @Override
    public PsiReference getReference() {
        GLSLReferenceElement theRealReference = getRealReference();
        if (theRealReference != null) {
            return theRealReference.getReferenceProxy();
        } else {
            return null;
        }
    }
    /*
    @NotNull
    @Override
    public PsiReference[] getReferences() {
        GLSLReferenceElement theRealReference = getRealReference();
        if(theRealReference!=null) {
            return theRealReference.getReferencesProxy();
        } else {
            return PsiReference.EMPTY_ARRAY;
        }
    }
    */
}