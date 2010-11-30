package glslplugin.lang.elements.statements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypes;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLReturnStatement extends GLSLStatement {

    public GLSLReturnStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    // TODO: Implement

    @Override
    public String toString() {
        return "Return Statement";
    }

    public GLSLType getReturnType() {
        PsiElement child = findChildByClass(GLSLExpression.class);
        if (child != null && child instanceof GLSLExpression) {
            GLSLExpression expr = (GLSLExpression) child;
            return expr.getType(); //todo: problem with function calls...
        } else {
            //return;
            return GLSLTypes.VOID;
        }
    }
}