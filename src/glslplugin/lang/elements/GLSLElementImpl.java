package glslplugin.lang.elements;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.parser.GLSLFile;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 14.sep.2008
 * Time: 17:42:22
 */
public class GLSLElementImpl extends ASTWrapperPsiElement implements GLSLElement {

    public GLSLElementImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public String toString() {
        return "GLSLElementImpl:" + getNode().getElementType();
    }


    ////////////////////////////
    // Utility methods.

    public <T extends GLSLElement> T findParentByClass(Class<T> clazz) {
        return clazz.cast(findParentByClasses(clazz));
    }

    public GLSLElement findParentByClasses(Class<? extends GLSLElement>... clazzes) {
        PsiElement parent = getParent();
        while (parent != null) {
            for (Class<? extends GLSLElement> clazz : clazzes) {
                if (clazz.isInstance(parent)) {
                    return clazz.cast(parent);
                }
            }
            parent = parent.getParent();
        }
        return null;
    }

    public <T extends GLSLElement> T findPrevSiblingByClass(Class<T> clazz) {
        return clazz.cast(findPrevSiblingByClasses(clazz));
    }

    public GLSLElement findPrevSiblingByClasses(Class<? extends GLSLElement>... clazzes) {
        PsiElement prev = getPrevSibling();
        while (prev != null) {
            for (Class<? extends GLSLElement> clazz : clazzes) {
                if (clazz.isInstance(prev)) {
                    return clazz.cast(prev);
                }
            }
            prev = prev.getPrevSibling();
        }
        return null;
    }

    /**
     * Checks whether this is a descendant of elt.
     * That is; if elt is an ancestor of this.
     * Loops through the parent chains and reports whether or not elt is found.
     *
     * @param ancestor the proposed ancestor of this.
     * @return true if ancestor is indeed the ancestor of this, false otherwise.
     */
    public boolean isDescendantOf(PsiElement ancestor) {
        PsiElement current = this;
        while (current != null && !(current instanceof GLSLFile)) {
            if (current == ancestor) {
                return true;
            }
            current = current.getParent();
        }
        return false;
    }
}
