package glslplugin.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import glslplugin.lang.GLSLLanguage;

/**
 * Language file type
 */
public class GLSLFileType extends LanguageFileType {

    public GLSLFileType() {
        super(new GLSLLanguage());
    }

    @NotNull
    @NonNls
    public String getName() {
        return "GLSL shader file";
    }

    @NotNull
    public String getDescription() {
        return "OpenGL Shading Language file";
    }

    @NotNull
    @NonNls
    public String getDefaultExtension() {
        return "glsl";
    }

    @Nullable
    public Icon getIcon() {
        return IconLoader.getIcon("/icons/GLSLmini.png");
    }
}
