package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLElementImpl;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * GLSLDeclaratorList is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 7:10:04 PM
 */
public class GLSLDeclaratorList extends GLSLElementImpl implements Iterable<GLSLDeclarator> {
    public GLSLDeclaratorList(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLDeclarator[] getDeclarators() {
        return findChildrenByClass(GLSLDeclarator.class);
    }

    public GLSLVariableDeclaration getParentDeclaration() {
        return (GLSLVariableDeclaration) getParent();
    }

    @Override
    public String toString() {
        return "Declarator List (" + getDeclarators().length + " declarators)";
    }

    public Iterator<GLSLDeclarator> iterator() {
        return java.util.Arrays.asList(getDeclarators()).iterator();
    }
}
