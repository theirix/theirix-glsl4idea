package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * NewParameterDeclaration is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 2:04:56 PM
 */
public class GLSLParameterDeclaration extends GLSLSingleDeclarationImpl {
    public GLSLParameterDeclaration(@NotNull ASTNode astNode) {
        super(astNode);
    }

    boolean hasDeclarator() {
        return findChildByClass(GLSLDeclarator.class) != null;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("Parameter Declaration: ");
        b.append(getTypeSpecifierNode().getTypeName());
        if (hasDeclarator()) {
            b.append(getDeclaredName());
        }
        return b.toString();
    }
}
