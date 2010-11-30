package glslplugin.structureview;

import glslplugin.lang.elements.declarations.GLSLFunctionDeclaration;
import glslplugin.lang.elements.declarations.GLSLFunctionDeclarationImpl;
import glslplugin.lang.elements.declarations.GLSLFunctionDefinition;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         created: 2009-02-06 13:13
 */
public class GLSLFunctionTreeElement extends GLSLStructureViewTreeElement<GLSLFunctionDeclarationImpl> {
    public GLSLFunctionTreeElement(GLSLFunctionDeclarationImpl function) {
        super(function);

    }

    protected GLSLPresentation createPresentation(GLSLFunctionDeclarationImpl function) {
        if(function instanceof GLSLFunctionDefinition) {
            return GLSLPresentation.createMethodPresentation(function.getSignature());
        } else {
            return GLSLPresentation.createPrototypePresentation(function.getSignature());
        }
    }

    protected void createChildren(GLSLFunctionDeclarationImpl glslFunctionDeclaration) {

    }
}
