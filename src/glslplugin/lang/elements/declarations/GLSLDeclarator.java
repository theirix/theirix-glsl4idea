package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLIdentifier;
import glslplugin.lang.elements.expressions.GLSLExpression;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLDeclarator represents a local or global variable declaration.
 * It may contain one or more declarators.
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 29, 2009
 *         Time: 7:29:46 PM
 */
public class GLSLDeclarator extends GLSLDeclaratorBase {
    public GLSLDeclarator(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public boolean hasInitializer() {
        return findChildByClass(GLSLInitializer.class) != null;
    }

    public boolean hasIdentifier() {
        return findChildByClass(GLSLIdentifier.class) != null;
    }

    public GLSLExpression getInitializerExpression() {
        final GLSLInitializer init = findChildByClass(GLSLInitializer.class);
        if (init != null) {
            return init.getInitializerExpression();
        } else {
            throw new RuntimeException("Check for initializer before asking for it!");
        }
    }

    public GLSLArraySpecifier getArraySpecifier() {
        return findChildByClass(GLSLArraySpecifier.class);
    }
}
