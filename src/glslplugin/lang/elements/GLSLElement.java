package glslplugin.lang.elements;

import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;

/**
 * GLSLElement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 6, 2009
 *         Time: 1:33:24 PM
 */
public interface GLSLElement extends NavigatablePsiElement {
    <T extends GLSLElement> T findParentByClass(Class<T> clazz);

    GLSLElement findParentByClasses(Class<? extends GLSLElement>... clazzes);

    <T extends GLSLElement> T findPrevSiblingByClass(Class<T> clazz);

    GLSLElement findPrevSiblingByClasses(Class<? extends GLSLElement>... clazzes);

    /**
     * Checks whether this is a descendant of elt.
     * That is; if elt is an ancestor of this.
     * Loops through the parent chains and reports whether or not elt is found.
     *
     * @param ancestor the proposed ancestor of this.
     * @return true if ancestor is indeed the ancestor of this, false otherwise.
     */
    boolean isDescendantOf(PsiElement ancestor);
}
