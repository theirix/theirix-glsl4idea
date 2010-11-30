package glslplugin.lang.elements.reference;

import glslplugin.lang.elements.declarations.GLSLDeclarator;
import glslplugin.lang.elements.expressions.GLSLIdentifierExpression;

/**
 * GLSLVariableReference is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 4, 2009
 *         Time: 1:29:50 AM
 */
public class GLSLVariableReference extends GLSLReferenceBase<GLSLIdentifierExpression, GLSLDeclarator> {
    public GLSLVariableReference(GLSLIdentifierExpression source, GLSLDeclarator target) {
        super(source, target);
    }
}
