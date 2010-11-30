package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glslplugin.lang.elements.GLSLElementImpl;
import glslplugin.lang.elements.GLSLIdentifier;
import glslplugin.lang.elements.GLSLTypedElement;
import glslplugin.lang.elements.types.GLSLStructType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * GLSLDeclarator is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 27, 2009
 *         Time: 10:31:13 AM
 */
public class GLSLTypeDefinition extends GLSLElementImpl implements GLSLTypedElement {
    // Cache this one to enable equals comparison by ==
    //  this is required to be able to compare types of variables of anonymous types.
    // struct {int x;} x, y; <- how to compare types of x and y?
    private GLSLStructType type;

    public GLSLTypeDefinition(@NotNull ASTNode astNode) {
        super(astNode);
    }

    private String getTypeNameInternal() {
        final PsiElement[] children = getChildren();
        if (children.length > 1) {
            PsiElement id = children[0];
            if (id instanceof GLSLIdentifier) {
                return ((GLSLIdentifier) id).getIdentifierName();
            }
        }
        return null;
    }

    public boolean isNamed() {
        return getTypeNameInternal() != null;
    }

    @NotNull
    public String getTypeName() {
        String name = getTypeNameInternal();
        if (name != null) {
            return name;
        } else {
            return "(anonymous structure)";
        }
    }

    public GLSLTypeDefinition getTypeDefinition() {
        return this;
    }

    // TODO: Add getMemberDeclarations, findMember(String), etc...
    public GLSLDeclarationList getDeclarationList() {
        GLSLDeclarationList list = findChildByClass(GLSLDeclarationList.class);
        assert list != null;
        return list;
    }

    public GLSLDeclaration[] getDeclarations() {
        return getDeclarationList().getDeclarations();
    }

    public GLSLDeclarator[] getDeclarators() {
        List<GLSLDeclarator> declarators = new ArrayList<GLSLDeclarator>();
        for (GLSLDeclaration declaration : getDeclarations()) {
            for (GLSLDeclarator declarator : declaration.getDeclarators()) {
                declarators.add(declarator);
            }
        }
        return declarators.toArray(new GLSLDeclarator[declarators.size()]);
    }

    @Override
    public String toString() {
        return "Struct Type: " + getTypeName();
    }

    @NotNull
    public GLSLStructType getType() {
        if (type == null) {
            type = new GLSLStructType(this);
        }
        return type;
    }

    public GLSLDeclarator getDeclarator(@NotNull String name) {
        for (GLSLDeclarator declarator : getDeclarators()) {
            if (name.equals(declarator.getIdentifierName())) {
                return declarator;
            }
        }
        return null;
    }
}
