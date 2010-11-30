package glslplugin;

import com.intellij.lang.PairedBraceMatcher;
import com.intellij.lang.BracePair;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import static glslplugin.lang.elements.GLSLTokenTypes.*;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 13.sep.2008
 * Time: 22:16:49
 */
public class GLSLPairedBraceMatcher implements PairedBraceMatcher {
    private BracePair[] bracePairs = new BracePair[] {
            new BracePair(LEFT_BRACE, RIGHT_BRACE, true),
            new BracePair(LEFT_PAREN, RIGHT_PAREN, false),
            new BracePair(LEFT_BRACKET, RIGHT_BRACKET, false),
    };

    public BracePair[] getPairs() {
        return bracePairs;
    }

    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
        return true;
    }

    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        // TODO: IMPLEMENT
        return openingBraceOffset;
    }
}
