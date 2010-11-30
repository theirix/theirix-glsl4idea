package glslplugin.lang.elements.statements;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLDoStatement extends GLSLStatement implements ConditionStatement {
    public GLSLDoStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getConditionExpression() {
        GLSLExpression condition = findChildByClass(GLSLExpression.class);
        //todo: condition == null when the expression is a declaration
        assert condition != null;
        return condition;
    }

    // TODO: Implement

    @Override
    public String toString() {
        return "Do-While Loop";
    }
}