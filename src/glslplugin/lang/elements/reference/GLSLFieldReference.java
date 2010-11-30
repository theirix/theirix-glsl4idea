package glslplugin.lang.elements.reference;

import glslplugin.lang.elements.GLSLIdentifier;
import glslplugin.lang.elements.declarations.GLSLDeclarator;

/**
 * GLSLFieldReference is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 1, 2009
 *         Time: 11:07:52 PM
 */
public class GLSLFieldReference extends GLSLReferenceBase<GLSLIdentifier, GLSLDeclarator> {
    public GLSLFieldReference(GLSLIdentifier source, GLSLDeclarator target) {
        super(source, target);
    }
}
