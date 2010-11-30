package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLAssignmentExpression is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 30, 2009
 *         Time: 10:51:02 AM
 */
public class GLSLAssignmentExpression extends GLSLBinaryOperatorExpression {
    public GLSLAssignmentExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public String toString() {
        return "Assignemt: " + getOperator().getTextRepresentation();
    }
}
