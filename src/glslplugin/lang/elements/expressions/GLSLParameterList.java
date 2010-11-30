package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLTokenTypes;
import glslplugin.lang.elements.types.GLSLType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * GLSLParameterList is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 29, 2009
 *         Time: 10:36:17 AM
 */
public class GLSLParameterList extends GLSLElementImpl implements Iterable<GLSLExpression> {
    public GLSLParameterList(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression[] getParameters() {
        // convert the list of children to a list of GLSLStatement objects while performing sanity check.
        PsiElement[] children = getChildren();
        List<GLSLExpression> result = new ArrayList<GLSLExpression>(children.length);
        for (PsiElement child : children) {
            if (child instanceof GLSLExpression) {
                result.add((GLSLExpression) child);
            } else {
                final ASTNode node = child.getNode();
                if (node != null) {
                    final IElementType type = node.getElementType();
                    if (!GLSLTokenTypes.COMMENTS.contains(type)) {
                        throw new RuntimeException("Parameter list contains non-comment, non-expression element.");
                    }
                }
            }
        }
        return result.toArray(new GLSLExpression[result.size()]);
    }

    public GLSLType[] getParameterTypes() {
        // convert the list of children to a list of GLSLStatement objects while performing sanity check.
        PsiElement[] children = getChildren();
        List<GLSLType> result = new ArrayList<GLSLType>(children.length);
        for (PsiElement child : children) {
            if (child instanceof GLSLExpression) {
                result.add(((GLSLExpression) child).getType());
            } else {
                final ASTNode node = child.getNode();
                if (node != null) {
                    final IElementType type = node.getElementType();
                    if (!GLSLTokenTypes.COMMENTS.contains(type)) {
                        throw new RuntimeException("Parameter list contains non-comment, non-expression element.");
                    }
                }
            }
        }
        return result.toArray(new GLSLType[result.size()]);
    }

    public Iterator<GLSLExpression> iterator() {
        return java.util.Arrays.asList(getParameters()).iterator();
    }

    @Override
    public String toString() {
        return "Parameter List (" + getParameters().length + " parameters)";
    }
}
