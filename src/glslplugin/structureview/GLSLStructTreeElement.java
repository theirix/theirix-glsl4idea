package glslplugin.structureview;

import glslplugin.lang.elements.declarations.GLSLDeclaration;
import glslplugin.lang.elements.declarations.GLSLDeclarator;
import glslplugin.lang.elements.declarations.GLSLTypeDefinition;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-02-06 12:58
 */
public class GLSLStructTreeElement extends GLSLStructureViewTreeElement<GLSLTypeDefinition> {
    public GLSLStructTreeElement(GLSLTypeDefinition definition) {
        super(definition);
    }

    protected GLSLPresentation createPresentation(GLSLTypeDefinition definition) {
        return GLSLPresentation.createStructPresentation(definition.getTypeName());
    }

    protected void createChildren(GLSLTypeDefinition definition) {
        GLSLDeclaration[] glslDeclarations = definition.getDeclarations();
        for (GLSLDeclaration declaration : glslDeclarations) {
            for (GLSLDeclarator declarator : declaration.getDeclarators()) {
                addChild(new GLSLDeclaratorTreeElement(declarator));
            }
        }
    }
}
