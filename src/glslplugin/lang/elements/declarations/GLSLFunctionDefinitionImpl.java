package glslplugin.lang.elements.declarations;

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.statements.GLSLCompoundStatement;

/**
 * NewFunctionDefinition is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 12:32:21 PM
 */
public class GLSLFunctionDefinitionImpl extends GLSLFunctionDeclarationImpl implements GLSLFunctionDefinition {
    public GLSLFunctionDefinitionImpl(ASTNode node) {
        super(node);
    }

    public GLSLCompoundStatement getBody() {
        GLSLCompoundStatement statement = findChildByClass(GLSLCompoundStatement.class);
        assert statement != null;
        return statement;
    }

    @Override
    public String toString() {
        return "Function Definition: " + getSignature();
    }
}
