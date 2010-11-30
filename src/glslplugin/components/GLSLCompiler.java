package glslplugin.components;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileScope;
import com.intellij.openapi.compiler.TranslatingCompiler;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Chunk;
import glslplugin.GLSLSupportLoader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-02-02 18:08
 */
public class GLSLCompiler implements TranslatingCompiler {
    @NotNull
    public String getDescription() {
        return "Compiles GLSL files and displays compiler messages";
    }

    @Override
    public boolean validateConfiguration(CompileScope compileScope) {
        //todo: check filetype and if another compiler for this filetype exists?
        return true;
    }

    @Override
    public boolean isCompilableFile(VirtualFile virtualFile, CompileContext compileContext) {
        return GLSLSupportLoader.GLSL.equals(FileTypeManager.getInstance().getFileTypeByFile(virtualFile));
    }

    @Override
    public void compile(CompileContext context, Chunk<Module> moduleChunk, VirtualFile[] files, OutputSink sink) {
        Application application = ApplicationManager.getApplication();
        ExitResult result = application.runReadAction(new GLSLCompileAction(context, files));

        /*if (result.isNeedUpdateCaches()) {
            context.getProgressIndicator().pushState();
            context.getProgressIndicator().setText(Native2AsciiBundle.message("progress.updating.caches"));
            CompilerUtil.refreshIOFiles(result.getTranslatedFiles());
            context.getProgressIndicator().popState();
        }*/
    }

    private class ExitResult {
        private List<SuccessItem> successes;

        public ExitResult(List<SuccessItem> successes) {
            this.successes = successes;
        }

        public OutputItem[] getSuccessfullyCompiled() {
            //return successes.toArray(new OutputItem[successes.size()]);
            return new OutputItem[0];
        }

        public VirtualFile[] getFilesToRecompile() {
            return new VirtualFile[0];
        }
    }

    private class SuccessItem implements OutputItem {
        private VirtualFile virtualFile;

        private SuccessItem(VirtualFile virtualFile) {
            this.virtualFile = virtualFile;
        }

        public String getOutputPath() {
            return null;
        }

        public VirtualFile getSourceFile() {
            return virtualFile;
        }

        public String getOutputRootDirectory() {
            return null;
        }
    }

    private class GLSLCompileAction implements Computable<ExitResult> {
        private CompileContext context;
        private VirtualFile[] files;

        public GLSLCompileAction(CompileContext context, VirtualFile[] files) {
            this.context = context;
            this.files = files;
        }

        public ExitResult compute() {
            List<SuccessItem> successes = new ArrayList<SuccessItem>();
            for (VirtualFile virtualFile : files) {
                successes.add(new SuccessItem(virtualFile));
                //todo: compile and parse output
                //todo: maybe show all output if any is generated and not parse...
                //todo: problem with integrating JOGL. configuration dialog?
                context.addMessage(CompilerMessageCategory.ERROR, "Unable to compile!", virtualFile.getUrl(), -1, -1);
            }


            return new ExitResult(successes);
        }
    }

}
