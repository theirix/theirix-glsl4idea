package glslplugin.lang.elements.declarations;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.statements.GLSLStatement;
import glslplugin.lang.elements.declarations.GLSLVariableDeclaration;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLDeclarationStatement extends GLSLStatement {
    public GLSLDeclarationStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLVariableDeclaration getDeclaration() {
        return (GLSLVariableDeclaration) getFirstChild();
    }

    @Override
    public String toString() {
        return "Declaration Statement";
    }
}
