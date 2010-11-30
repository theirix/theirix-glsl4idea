package glslplugin.lang.elements.reference;

import glslplugin.lang.elements.declarations.GLSLTypeDefinition;
import glslplugin.lang.elements.declarations.GLSLTypename;

/**
 * GLSLVariableReference is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 4, 2009
 *         Time: 1:29:50 AM
 */
public class GLSLTypeReference extends GLSLReferenceBase<GLSLTypename, GLSLTypeDefinition> {
    public GLSLTypeReference(GLSLTypename source, GLSLTypeDefinition target) {
        super(source, target);
    }
}