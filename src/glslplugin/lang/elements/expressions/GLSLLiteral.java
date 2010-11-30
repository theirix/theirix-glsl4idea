package glslplugin.lang.elements.expressions;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import glslplugin.lang.elements.GLSLTokenTypes;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypes;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLLiteral is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 1:50:35 PM
 */
public class GLSLLiteral extends GLSLPrimaryExpression {
    private enum Type {
        BOOL("Bool", GLSLTypes.BOOL),
        FLOAT("Float", GLSLTypes.FLOAT),
        INTEGER("Integer", GLSLTypes.INT);

        Type(String name, GLSLType type) {
            this.textRepresentation = name;
            this.type = type;
        }

        final String textRepresentation;
        final GLSLType type;
    }

    public GLSLLiteral(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public Type getLiteralType() {
        IElementType type = getNode().getFirstChildNode().getElementType();
        if (type == GLSLTokenTypes.BOOL_CONSTANT) return Type.BOOL;
        if (type == GLSLTokenTypes.INTEGER_CONSTANT) return Type.INTEGER;
        if (type == GLSLTokenTypes.FLOAT_CONSTANT) return Type.FLOAT;
        throw new RuntimeException("Unsupported literal type.");
    }

    public String toString() {
        return getLiteralType().textRepresentation + " Literal: '" + getText() + "'";
    }

    @NotNull
    @Override
    public GLSLType getType() {
        return getLiteralType().type;
    }
}
