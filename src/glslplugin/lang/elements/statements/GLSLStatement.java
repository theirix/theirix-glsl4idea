package glslplugin.lang.elements.statements;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLElementImpl;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 5:53:03 PM
 */
public abstract class GLSLStatement extends GLSLElementImpl {
    public GLSLStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }
}
