package glslplugin.lang.elements.expressions;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.expressions.GLSLSelectionExpressionBase;
import glslplugin.lang.elements.expressions.GLSLParameterList;
import glslplugin.lang.elements.GLSLIdentifier;

/**
 * GLSLMethodCall is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 3, 2009
 *         Time: 12:41:53 PM
 */
public class GLSLMethodCallExpression extends GLSLSelectionExpressionBase {
    public GLSLMethodCallExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLIdentifier getMethodIdentifier() {
        GLSLIdentifier id = findChildByClass(GLSLIdentifier.class);
        if (id != null) {
            return id;
        } else {
            throw new RuntimeException("Method call expression with no method identifier.");
        }
    }

    public String getMethodName() {
        return getMethodIdentifier().getIdentifierName();
    }

    public GLSLParameterList getParameterList() {
        final PsiElement last = getLastChild();
        return (GLSLParameterList) last;
    }

    @Override
    public String toString() {
        return "Method Call: " + getMethodName();
    }
}
