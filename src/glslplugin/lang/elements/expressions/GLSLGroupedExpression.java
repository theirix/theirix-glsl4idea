package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.types.GLSLType;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLGroupedExpression is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 2:27:41 PM
 */
public class GLSLGroupedExpression extends GLSLPrimaryExpression {
    public GLSLGroupedExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getExpression() {
        GLSLExpression expr = findChildByClass(GLSLExpression.class);
        if (expr != null) {
            return expr;
        } else {
            throw new RuntimeException("Grouped expression does not contain any expression!");
        }
    }

    @NotNull
    @Override
    public GLSLType getType() {
        return getExpression().getType();
    }

    public String toString() {
        return "Grouped Expression: '()'";
    }
}
