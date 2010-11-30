package glslplugin.structureview;

import glslplugin.lang.elements.declarations.GLSLDeclarator;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-02-06 13:05
 */
public class GLSLDeclaratorTreeElement extends GLSLStructureViewTreeElement<GLSLDeclarator> {
    public GLSLDeclaratorTreeElement(GLSLDeclarator declarator) {
        super(declarator);
    }

    protected void createChildren(GLSLDeclarator dec) {
    }

    protected GLSLPresentation createPresentation(GLSLDeclarator dec) {
        return GLSLPresentation.createFieldPresentation(dec);
    }
}
