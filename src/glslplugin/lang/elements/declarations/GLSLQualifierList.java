package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLElementImpl;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * NewQualifierList is simply a list of qualifiers.
 * It implements <code>Iterable&lt;NewQualifier&gt;</code> for easy iteration,
 * as well as <code>getQualifiers() : NewQualifier[]</code> for easy access.
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 9:58:52 AM
 */
public class GLSLQualifierList extends GLSLElementImpl implements Iterable<GLSLQualifier> {
    public GLSLQualifierList(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLQualifier[] getQualifiers() {
        return findChildrenByClass(GLSLQualifier.class);
    }

    public Iterator<GLSLQualifier> iterator() {
        return java.util.Arrays.asList(getQualifiers()).iterator();
    }

    @Override
    public String toString() {
        return "Qualifier List: (" + getQualifiers().length + " qualifiers)";
    }

    public boolean containsQualifier(GLSLQualifier.Qualifier qualifier) {
        for (GLSLQualifier qualifierElement : getQualifiers()) {
            if (qualifierElement.getQualifier() == qualifier) {
                return true;
            }
        }
        return false;
    }
}
