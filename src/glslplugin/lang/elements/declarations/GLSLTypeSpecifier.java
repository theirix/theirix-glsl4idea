package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLTypedElement;
import glslplugin.lang.elements.types.GLSLArrayType;
import glslplugin.lang.elements.types.GLSLType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 28, 2009
 *         Time: 11:21:30 PM
 *         To change this template use File | Settings | File Templates.
 */
public class GLSLTypeSpecifier extends GLSLElementImpl {
    public GLSLTypeSpecifier(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLArraySpecifier getArraySpecifierNode() {
        PsiElement[] children = getChildren();
        if (children.length == 2) {
            final PsiElement array = children[1];
            if (array instanceof GLSLArraySpecifier) {
                return ((GLSLArraySpecifier) array);
            }
        }
        return null;
    }

    public GLSLType getType() {
        // GLSLTypedElement is either a type definition or type reference
        GLSLTypedElement reference = findChildByClass(GLSLTypedElement.class);
        GLSLArraySpecifier array = getArraySpecifierNode();
        if (reference != null) {
            final GLSLType type = reference.getType();
            if (array != null) {
                return new GLSLArrayType(type, array);
            }
            return type;
        } else {
            // TODO: Return the unknown type instead of throwing?
            throw new RuntimeException("Type specifier is missing the type.");
        }
    }

    public String getTypeName() {
        return getType().getTypename();
    }

    @Override
    public String toString() {
        return "Type Specifier: " + getTypeName();
    }

    public GLSLTypedElement getTypeDefinition() {
        return findChildByClass(GLSLTypeDefinition.class);
    }
}
