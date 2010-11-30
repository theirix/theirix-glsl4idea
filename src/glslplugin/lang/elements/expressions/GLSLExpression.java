package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLTypedElement;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypes;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLExpression is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 2:30:00 PM
 */
public abstract class GLSLExpression extends GLSLElementImpl implements GLSLTypedElement {
    public GLSLExpression(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public boolean isLValue() {
        return false;
    }

    @NotNull
    public GLSLType getType() {
        return GLSLTypes.UNKNOWN_TYPE;
    }
}
