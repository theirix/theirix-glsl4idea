package glslplugin.lang.parser;

import com.intellij.psi.FileViewProvider;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import glslplugin.GLSLSupportLoader;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 14.sep.2008
 * Time: 18:44:07
 */
public class GLSLFile extends PsiFileBase {
    public GLSLFile(FileViewProvider fileViewProvider) {
        super(fileViewProvider, GLSLSupportLoader.GLSL.getLanguage());
    }

    @NotNull
    public FileType getFileType() {
        return GLSLSupportLoader.GLSL;
    }
}
