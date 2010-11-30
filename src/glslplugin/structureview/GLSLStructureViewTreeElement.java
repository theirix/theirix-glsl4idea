package glslplugin.structureview;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         Date: 30.jan.2009
 *         Time: 09:48:09
 */
abstract class GLSLStructureViewTreeElement<T extends PsiElement> implements StructureViewTreeElement {
    private T element;
    private List<StructureViewTreeElement> children = new ArrayList<StructureViewTreeElement>();

    public GLSLStructureViewTreeElement(T element) {
        this.element = element;
    }

    protected abstract void createChildren(T t);

    protected void addChild(GLSLStructureViewTreeElement child) {
        children.add(child);
    }

    protected abstract GLSLPresentation createPresentation(T element);

    public T getValue() {
        return element;
    }

    public ItemPresentation getPresentation() {
        return createPresentation(element);
    }

    public TreeElement[] getChildren() {
        children.clear();
        createChildren(element);
        return children.toArray(new TreeElement[children.size()]);
    }

    public void navigate(boolean requestFocus) {
        if (element instanceof NavigatablePsiElement) {
            ((NavigatablePsiElement) element).navigate(requestFocus);
        }
    }

    public boolean canNavigate() {
        return element instanceof NavigatablePsiElement && ((NavigatablePsiElement) element).canNavigate();
    }

    public boolean canNavigateToSource() {
        return element instanceof NavigatablePsiElement && ((NavigatablePsiElement) element).canNavigateToSource();
    }
}
