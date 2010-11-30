package glslplugin.components;

import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class GLSLTemplatesLoader implements ApplicationComponent {
    private String templateText = "#version 120\n\nvoid main() {\n\n}";

    public GLSLTemplatesLoader() {
    }

    @NotNull
    public String getComponentName() {
        return "GLSL Template Loader";
    }

    public void initComponent() {
        FileTemplateManager fileTemplateManager = FileTemplateManager.getInstance();

        if (fileTemplateManager.getTemplate("GLSL Shader") == null) {
            final FileTemplate template = fileTemplateManager.addTemplate("GLSL Shader", "glsl");

            template.setText(templateText);
        }
    }

    public void disposeComponent() {
        FileTemplateManager fileTemplateManager = FileTemplateManager.getInstance();

        FileTemplate template = fileTemplateManager.getTemplate("GLSL Shader");
        if (template != null) {
            fileTemplateManager.removeTemplate(template, true);
        }
    }
}
