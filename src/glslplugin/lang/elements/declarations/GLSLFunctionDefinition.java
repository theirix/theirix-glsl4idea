package glslplugin.lang.elements.declarations;

import glslplugin.lang.elements.statements.GLSLCompoundStatement;

/**
 * NewFunctionDefinition is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 12:33:24 PM
 */
public interface GLSLFunctionDefinition extends GLSLFunctionDeclaration {
    GLSLCompoundStatement getBody();
}
