package glslplugin.lang.elements.declarations;

import glslplugin.lang.elements.GLSLTypedElement;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.types.GLSLFunctionType;
import glslplugin.lang.elements.types.GLSLTypeCompatibilityLevel;

/**
 * NewFunctionDeclaration represents a function declaration.
 * It inherits the name, qualifier and (return) type from {@link glslplugin.lang.elements.declarations.GLSLDeclaration} and adds the parameter list.
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 1:17:34 AM
 */
public interface GLSLFunctionDeclaration extends GLSLSingleDeclaration, GLSLTypedElement {

    GLSLParameterDeclaration[] getParameters();

    GLSLDeclarationList getParameterList();

    GLSLTypeCompatibilityLevel getParameterCompatibliltyLevel(GLSLExpression[] parameters);

    String getSignature();

    GLSLFunctionType getType();
}
