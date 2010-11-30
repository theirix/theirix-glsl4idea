package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLIdentifier;
import glslplugin.lang.elements.types.GLSLArrayType;
import glslplugin.lang.elements.types.GLSLQualifiedType;
import glslplugin.lang.elements.types.GLSLType;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLDeclaratorBase is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 27, 2009
 *         Time: 10:31:13 AM
 */
public class GLSLDeclaratorBase extends GLSLElementImpl {

    public GLSLDeclaratorBase(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @NotNull
    public GLSLIdentifier getIdentifier() {
        PsiElement idElement = getFirstChild();
        if (idElement instanceof GLSLIdentifier) {
            return (GLSLIdentifier) idElement;
        } else {
            throw new RuntimeException("First element of declarator is not identifier.");
        }
    }

    public String getIdentifierName() {
        PsiElement idElement = getFirstChild();
        if (idElement instanceof GLSLIdentifier) {
            return ((GLSLIdentifier) idElement).getIdentifierName();
        } else {
            return "(anonymous)";
        }
    }

    private GLSLArraySpecifier getArraySpecifier() {
        return findChildByClass(GLSLArraySpecifier.class);
    }

    public GLSLDeclaration getParentDeclaration() {
        return findParentByClass(GLSLDeclarationImpl.class);
    }

    @NotNull
    public GLSLType getType() {
        GLSLArraySpecifier arraySpecifier = getArraySpecifier();
        GLSLDeclaration declaration = getParentDeclaration();

        GLSLTypeSpecifier declarationType = declaration.getTypeSpecifierNode();

        if (arraySpecifier != null) {
            return new GLSLArrayType(declarationType.getType(), declarationType.getArraySpecifierNode());
        } else {
            return declarationType.getType();
        }
    }

    public GLSLQualifiedType getQualifiedType() {
        GLSLDeclaration declaration = getParentDeclaration();
        return new GLSLQualifiedType(getType(), declaration.getQualifierList().getQualifiers());
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Declarator: ").append(getIdentifierName());
        b.append(" : ").append(getType().getTypename());
        if (getType().getArraySpecifier() != null) {
            b.append("[]");
        }
        return b.toString();
    }
}
