package glslplugin.components;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.compiler.Compiler;
import com.intellij.openapi.compiler.CompilerManager;
import org.jetbrains.annotations.NotNull;
import glslplugin.GLSLSupportLoader;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-02-02 18:07
 */
public class GLSLCompilerManager implements ProjectComponent {
    private final Compiler compiler;
    private Project project;

    public GLSLCompilerManager(Project project) {

        this.project = project;
        compiler = new GLSLCompiler();
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "GLSLCompilerManager";
    }

    public void projectOpened() {
        CompilerManager.getInstance(project).addCompiler(compiler);
        CompilerManager.getInstance(project).addCompilableFileType(GLSLSupportLoader.GLSL);
    }

    public void projectClosed() {
        CompilerManager.getInstance(project).removeCompiler(compiler);
        CompilerManager.getInstance(project).removeCompilableFileType(GLSLSupportLoader.GLSL);
    }
}
