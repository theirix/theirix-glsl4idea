package glslplugin.structureview;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.ide.structureView.StructureView;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.psi.PsiFile;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2009 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 29.jan.2009
 * Time: 21:50:32
 */
public class GLSLStructureViewFactory implements PsiStructureViewFactory {
    public StructureViewBuilder getStructureViewBuilder(final PsiFile psiFile) {
        return new TreeBasedStructureViewBuilder() {
            @NotNull
            public StructureViewModel createStructureViewModel() {
                return new GLSLStructureViewModel(psiFile);
            }
        };
    }
}
