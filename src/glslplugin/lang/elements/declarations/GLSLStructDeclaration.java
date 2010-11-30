package glslplugin.lang.elements.declarations;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.declarations.GLSLDeclarationImpl;

/**
 * NewStructDeclaration is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 3:52:15 PM
 */
public class GLSLStructDeclaration extends GLSLDeclarationImpl {
    public GLSLStructDeclaration(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public String toString() {
        return "Struct Declaration: " + getDeclaratorsString();
    }
}
