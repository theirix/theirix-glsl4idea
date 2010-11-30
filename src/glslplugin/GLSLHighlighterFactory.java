package glslplugin;

import com.intellij.openapi.fileTypes.SyntaxHighlighterProvider;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2009 Yngve D. Hammersland
 * User: jeanpaul
 * Date: 15.feb.2009
 * Time: 13:32:07
 */
public class GLSLHighlighterFactory extends SyntaxHighlighterFactory {

    public GLSLHighlighterFactory()
    {
        super();
    }

    @NotNull
    public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        return new GLSLHighlighter();
    }
}
