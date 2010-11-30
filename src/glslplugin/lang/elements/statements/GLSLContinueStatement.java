package glslplugin.lang.elements.statements;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.statements.GLSLStatement;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLContinueStatement extends GLSLStatement {
    public GLSLContinueStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    // TODO: Implement

    @Override
    public String toString() {
        return "Continue Statement";
    }
}