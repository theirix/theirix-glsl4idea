package glslplugin.structureview;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import glslplugin.lang.elements.GLSLTranslationUnit;
import glslplugin.lang.elements.GLSLTypedElement;
import glslplugin.lang.elements.declarations.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (c) 2009. Jean-Paul Balabanian
 *
 * @author jeanpaul
 *         Date: 30.jan.2009
 *         Time: 09:48:09
 */
class GLSLFileTreeElement extends GLSLStructureViewTreeElement<PsiFile> {

    public GLSLFileTreeElement(PsiFile file) {
        super(file);
    }

    protected GLSLPresentation createPresentation(PsiFile file) {
        return GLSLPresentation.createFilePresentation(file.getName());
    }

    protected void createChildren(PsiFile file) {
        Set<GLSLTypeDefinition> definitions = new LinkedHashSet<GLSLTypeDefinition>();
        List<GLSLVariableDeclaration> variableDeclarations = new ArrayList<GLSLVariableDeclaration>();
        List<GLSLFunctionDeclaration> functions = new ArrayList<GLSLFunctionDeclaration>();

        PsiElement translationUnit = file.getFirstChild();
        while (translationUnit != null && !(translationUnit instanceof GLSLTranslationUnit)) {
            translationUnit = translationUnit.getNextSibling();
        }

        if (translationUnit != null) {
            PsiElement[] baseNodes = translationUnit.getChildren();
            for (PsiElement baseNode : baseNodes) {
                if (baseNode instanceof GLSLVariableDeclaration) {
                    final GLSLVariableDeclaration declaration = (GLSLVariableDeclaration) baseNode;
                    final GLSLTypedElement typedef = declaration.getTypeSpecifierNode().getTypeDefinition();
                    if (typedef instanceof GLSLTypeDefinition) {
                        final GLSLTypeDefinition definition = (GLSLTypeDefinition) typedef;
                        definitions.add(definition);
                    }

                    if (declaration.getDeclarators().length > 0) {
                        variableDeclarations.add(declaration);
                    }
                } else if (baseNode instanceof GLSLFunctionDeclaration) {
                    functions.add((GLSLFunctionDeclaration) baseNode);
                }
            }

            for (GLSLTypeDefinition definition : definitions) {
                addChild(new GLSLStructTreeElement(definition));
            }

            for (GLSLVariableDeclaration declaration : variableDeclarations) {
                for (GLSLDeclarator declarator : declaration.getDeclarators()) {
                    addChild(new GLSLDeclaratorTreeElement(declarator));
                }
            }

            for (GLSLFunctionDeclaration function : functions) {
                addChild(new GLSLFunctionTreeElement((GLSLFunctionDeclarationImpl) function));
            }
        }
    }
}