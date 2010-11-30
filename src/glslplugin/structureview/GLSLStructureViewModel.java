package glslplugin.structureview;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.Grouper;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import glslplugin.lang.elements.declarations.GLSLDeclarationImpl;
import glslplugin.lang.elements.declarations.GLSLFunctionDeclarationImpl;
import glslplugin.lang.elements.declarations.GLSLTypeDefinition;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2009 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 30.jan.2009
 * Time: 09:47:58
 */
class GLSLStructureViewModel extends TextEditorBasedStructureViewModel {
    private PsiElement rootElement;

    public GLSLStructureViewModel(PsiElement element) {
        super(element.getContainingFile());
        this.rootElement = element;
    }

    protected PsiFile getPsiFile() {
        return rootElement.getContainingFile();
    }

    @NotNull
    public StructureViewTreeElement getRoot() {
        return new GLSLFileTreeElement(rootElement.getContainingFile());
    }

    @NotNull
    public Grouper[] getGroupers() {
        return Grouper.EMPTY_ARRAY;
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    @NotNull
    public Filter[] getFilters() {
        return Filter.EMPTY_ARRAY;
    }


    @NotNull
    @Override
    protected Class[] getSuitableClasses() {
        return new Class[]{GLSLFunctionDeclarationImpl.class, PsiFile.class, GLSLTypeDefinition.class, GLSLDeclarationImpl.class};
    }
}
