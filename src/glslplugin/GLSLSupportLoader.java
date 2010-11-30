package glslplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import org.jetbrains.annotations.NotNull;
import glslplugin.lang.GLSLFileType;

/**
 * Initiates GLSL support
 */
public class GLSLSupportLoader extends FileTypeFactory {
    public static final LanguageFileType GLSL = new GLSLFileType();

    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(GLSL,"glsl");
    }
}
