package glslplugin.lang.elements;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLTranslationUnit is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 29, 2009
 *         Time: 10:13:13 PM
 */
public class GLSLTranslationUnit extends GLSLElementImpl {
    public GLSLTranslationUnit(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public String toString() {
        return "Translation Unit";
    }
}
