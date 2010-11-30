package glslplugin.lang.elements.declarations;

import glslplugin.lang.elements.GLSLElement;

/**
 * GLSLDeclaration is a common interface for all declarations;
 * variable declarations, function declarations/definitions, and struct member declarations.
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 12:39:33 AM
 */
public interface GLSLDeclaration extends GLSLElement {
    GLSLTypeSpecifier getTypeSpecifierNode();

    GLSLQualifierList getQualifierList();

    GLSLDeclarator[] getDeclarators();
}
