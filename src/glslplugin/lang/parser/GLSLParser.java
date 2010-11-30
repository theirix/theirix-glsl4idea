package glslplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 14.sep.2008
 * Time: 17:06:50
 */
public class GLSLParser implements PsiParser {

    @NotNull
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        builder.setDebugMode(true);
        final PsiBuilder.Marker rootMarker = builder.mark();
        GLSLParsing theRealParser = new GLSLParsing(builder);
        try {
            theRealParser.parseTranslationUnit();

            while (!builder.eof()) {
                builder.advanceLexer();
            }

            rootMarker.done(root);
            return builder.getTreeBuilt();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
