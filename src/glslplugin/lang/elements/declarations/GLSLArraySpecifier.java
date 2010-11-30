package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.expressions.GLSLExpression;

/**
 * GLSLArrayDeclarator is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 29, 2009
 *         Time: 2:11:52 PM
 */
public class GLSLArraySpecifier extends GLSLElementImpl {
    public GLSLArraySpecifier(ASTNode node) {
        super(node);
    }

    public boolean hasSizeExpression() {
        return findChildByClass(GLSLExpression.class) != null;
    }

    public GLSLExpression getSizeExpression() {
        GLSLExpression expr = findChildByClass(GLSLExpression.class);
        if (expr != null) {
            return expr;
        } else {
            throw new RuntimeException("Check for array size expression before asking for it!");
        }
    }

    @Override
    public String toString() {
        return "Array Declarator";
    }
}
