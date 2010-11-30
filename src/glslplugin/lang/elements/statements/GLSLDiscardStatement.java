package glslplugin.lang.elements.statements;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLDiscardStatement extends GLSLStatement {
    public GLSLDiscardStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    // TODO: Implement

    @Override
    public String toString() {
        return "Discard Statement";
    }
}