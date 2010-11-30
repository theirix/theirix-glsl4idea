package glslplugin.lang;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import glslplugin.lang.elements.*;
import glslplugin.lang.parser.GLSLFile;
import glslplugin.lang.parser.GLSLParser;
import glslplugin.lang.scanner.GLSLFlexAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 13.sep.2008
 * Time: 14:30:29
 */
public class GLSLParserDefinition implements ParserDefinition {
    private static final GLSLPsiElementFactory psiFactory = new GLSLPsiElementFactoryImpl();

    @NotNull
    public Lexer createLexer(Project project) {
        return new GLSLFlexAdapter();
    }

    public PsiParser createParser(Project project) {
        return new GLSLParser();
    }

    public IFileElementType getFileNodeType() {
        return GLSLElementTypes.FILE;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return TokenSet.create(GLSLTokenTypes.WHITE_SPACE);
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return GLSLTokenTypes.COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        GLSLElement elt = psiFactory.create(node);
        if (elt != null) {
            return elt;
        } else {
            return new GLSLElementImpl(node);
        }
    }

    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new GLSLFile(fileViewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return null;
    }
}
