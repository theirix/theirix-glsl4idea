package glslplugin.lang.elements.declarations;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.declarations.GLSLDeclarationImpl;

/**
 * NewVariableDeclaration is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 1:14:40 AM
 */
public class GLSLVariableDeclaration extends GLSLDeclarationImpl {
    public GLSLVariableDeclaration(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public String toString() {
        return "Variable Declaration: " + getDeclaratorsString();
    }
}
