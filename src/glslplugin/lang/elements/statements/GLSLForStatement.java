package glslplugin.lang.elements.statements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.GLSLElement;
import glslplugin.lang.elements.GLSLTokenTypes;
import glslplugin.lang.elements.declarations.GLSLDeclaration;
import glslplugin.lang.elements.expressions.GLSLExpression;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLDeclarationStatement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 6:13:58 PM
 */
public class GLSLForStatement extends GLSLStatement implements ConditionStatement {

    public GLSLForStatement(@NotNull ASTNode astNode) {
        super(astNode);
    }

    /**
     * Fetches the initialization, the condition and the counter elements and places them in an array.
     * The array will always have length 3 and the elements are always placed in their respective places.
     * They will be null if missing.
     *
     * @return an array containing the loop elements.
     */
    @NotNull
    private GLSLElement[] getForElements() {
        GLSLElement result[] = new GLSLElement[3];
        int numberOfSemicolonsPassed = 0;
        PsiElement current = getFirstChild();
        while (current != null) {
            ASTNode node = current.getNode();
            if (current instanceof GLSLExpression || current instanceof GLSLDeclaration) {
                result[numberOfSemicolonsPassed] = (GLSLElement) current;
            } else if (node != null) {
                if (node.getElementType() == GLSLTokenTypes.SEMICOLON) {
                    numberOfSemicolonsPassed++;
                }
                if (node.getElementType() == GLSLTokenTypes.RIGHT_PAREN) {
                    break;
                }
            }

            current = current.getNextSibling();
        }
        return result;
    }

    /**
     * Fetches the loop initialization element.
     * May be an GLSLExpression or GLSLVariableDeclaration subclass.
     *
     * @return the loop initialization element.
     */
    public GLSLElement getInitializerElement() {
        return getForElements()[0];
    }

    /**
     * Fetches the loop condition element.
     * May be an GLSLExpression or GLSLVariableDeclaration subclass.
     *
     * @return the loop condition element.
     */
    public GLSLExpression getConditionExpression() {
        return (GLSLExpression) getForElements()[1];
    }

    /**
     * Fetches the loop counter expression.
     * It is always an GLSLExpression subclass, no declarations allowed here.
     *
     * @return the loop counter expression.
     */
    public GLSLExpression getCountExpression() {
        return (GLSLExpression) getForElements()[2];
    }


    public GLSLStatement getLoopStatement() {
        GLSLStatement statement = findChildByClass(GLSLStatement.class);
        assert statement != null;
        return statement;
    }


    @Override
    public String toString() {
        return "For Loop";
    }
}