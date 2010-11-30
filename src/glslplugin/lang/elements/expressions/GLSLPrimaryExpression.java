package glslplugin.lang.elements.expressions;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * GLSLPrimaryExpression is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 11:08:42 AM
 */
public class GLSLPrimaryExpression extends GLSLExpression {
    public GLSLPrimaryExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }
}
