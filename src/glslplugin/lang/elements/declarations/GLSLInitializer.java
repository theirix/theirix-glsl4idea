package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * GLSLInitializer is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 29, 2009
 *         Time: 2:09:11 PM
 */
public class GLSLInitializer extends GLSLExpression {
    public GLSLInitializer(@NotNull ASTNode astNode) {
        super(astNode);
    }

    GLSLExpression getInitializerExpression() {
        return (GLSLExpression) getFirstChild();
    }

    @Override
    public String toString() {
        return "Initializer";
    }
}
