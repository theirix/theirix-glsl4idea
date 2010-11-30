package glslplugin.lang.elements.statements;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.declarations.GLSLDeclarationStatement;
import glslplugin.lang.elements.declarations.GLSLVariableDeclaration;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLWhileStatement extends GLSLStatement implements ConditionStatement {
    public GLSLWhileStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLExpression getConditionExpression() {
        return findChildByClass(GLSLExpression.class);
    }
    
    GLSLStatement getLoopStatement() {
        GLSLStatement loop = findChildByClass(GLSLStatement.class);
        assert loop != null;
        return loop;
    }

    @Override
    public String toString() {
        return "While Loop";
    }
}