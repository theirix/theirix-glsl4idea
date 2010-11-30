package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * NewSingleDeclarationImpl is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 12:46:15 PM
 */
public class GLSLSingleDeclarationImpl extends GLSLDeclarationImpl implements GLSLSingleDeclaration {
    public GLSLSingleDeclarationImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public String getDeclaredName() {
        return getDeclarator().getIdentifierName();
    }

    /**
     * Overridden to provide the single GLSLIdentifier.
     * It is not packaged in DECLARATOR_LIST like the other declarations.
     *
     * @return the declarator list.
     */
    @Override
    public GLSLDeclarator[] getDeclarators() {
        return findChildrenByClass(GLSLDeclarator.class);
    }

    @NotNull
    public GLSLDeclarator getDeclarator() {
        GLSLDeclarator[] declarators = getDeclarators();
        assert declarators.length == 1;
        return declarators[0];
    }
}
