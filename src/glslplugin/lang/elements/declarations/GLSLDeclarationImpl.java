package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.GLSLElementImpl;
import org.jetbrains.annotations.NotNull;

/**
 * NewDeclarationBase is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 10:33:30 AM
 */
public class GLSLDeclarationImpl extends GLSLElementImpl implements GLSLDeclaration {
    public GLSLDeclarationImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public GLSLQualifier[] getQualifiers() {
        return getQualifierList().getQualifiers();
    }

    /**
     * Returns the type specifier Psi element for this declaration.
     * <p/>
     * <b>WARNING!</b>
     * <p/>
     * This is not a complete type of any variable as a declarator may contain an array specifier.
     * For the complete type use {@link glslplugin.lang.elements.declarations.GLSLDeclarator#getType()} instead.
     *
     * @return the type specifier.
     */
    public GLSLTypeSpecifier getTypeSpecifierNode() {
        GLSLTypeSpecifier typeSpecifier = findChildByClass(GLSLTypeSpecifier.class);
        assert typeSpecifier != null;
        return typeSpecifier;
    }

    @NotNull
    public GLSLQualifierList getQualifierList() {
        GLSLQualifierList list = findChildByClass(GLSLQualifierList.class);
        assert list != null;
        return list;
    }

    public GLSLDeclarator[] getDeclarators() {
        GLSLDeclaratorList list = findChildByClass(GLSLDeclaratorList.class);
        assert list != null;
        return list.getDeclarators();
    }

    protected String getDeclaratorsString() {
        StringBuilder b = new StringBuilder();
        boolean first = true;
        for (GLSLDeclarator declarator : getDeclarators()) {
            if (!first) {
                b.append(", ");
            }
            b.append(declarator.getIdentifier().getIdentifierName());
            first = false;
        }
        return b.toString();
    }
}
