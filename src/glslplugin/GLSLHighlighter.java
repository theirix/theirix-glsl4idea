package glslplugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import glslplugin.lang.scanner.GLSLFlexAdapter;
import static glslplugin.lang.elements.GLSLTokenTypes.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 13.sep.2008
 * Time: 15:38:35
 */
public class GLSLHighlighter extends SyntaxHighlighterBase {
    static final TextAttributesKey GLSL_NUMBER = TextAttributesKey.createTextAttributesKey("GLSL.NUMBER", SyntaxHighlighterColors.NUMBER.getDefaultAttributes());
    static final TextAttributesKey GLSL_TYPE_SPECIFIER = TextAttributesKey.createTextAttributesKey("GLSL.TYPE_SPECIFIER", new TextAttributes(new Color(0, 128, 128), null, null, null, Font.BOLD));
    static final TextAttributesKey GLSL_TYPE_QUALIFIERS = TextAttributesKey.createTextAttributesKey("GLSL.QUALIFIER_TOKENS", new TextAttributes(new Color(0, 128, 255), null, null, null, Font.BOLD));
    static final TextAttributesKey GLSL_PARAMETER_QUALIFIERS = TextAttributesKey.createTextAttributesKey("GLSL.PARAMETER_QUALIFIERS", new TextAttributes(new Color(128, 255, 0), null, null, null, Font.ITALIC));
    static final TextAttributesKey GLSL_FLOW_KEYWORDS = TextAttributesKey.createTextAttributesKey("GLSL.FLOW_KEYWORDS", new TextAttributes(new Color(255, 128, 0), null, null, null, Font.PLAIN));
    static final TextAttributesKey GLSL_COMMENT = TextAttributesKey.createTextAttributesKey("GLSL.COMMENT", SyntaxHighlighterColors.LINE_COMMENT.getDefaultAttributes());
    static final TextAttributesKey GLSL_IDENTIFIER = TextAttributesKey.createTextAttributesKey("GLSL.IDENTIFIER", new TextAttributes(Color.BLACK, null, null, null, Font.PLAIN));
    static final TextAttributesKey GLSL_COMPILER_DIRECTIVE_VERSION = TextAttributesKey.createTextAttributesKey("GLSL.COMPILER_DIRECTIVE_VERSION", new TextAttributes(Color.GREEN.darker().darker(), null, null, null, Font.ITALIC));
    static final TextAttributesKey GLSL_COMPILER_DIRECTIVE_EXTENSION = TextAttributesKey.createTextAttributesKey("GLSL.COMPILER_DIRECTIVE_EXTENSION", new TextAttributes(Color.GREEN.darker().darker(), null, null, null, Font.ITALIC));
    static final TextAttributesKey GLSL_COMPILER_DIRECTIVE_PRAGMA = TextAttributesKey.createTextAttributesKey("GLSL.COMPILER_DIRECTIVE_PRAGMA", new TextAttributes(Color.GREEN.darker().darker(), null, null, null, Font.ITALIC));
    static final TextAttributesKey GLSL_COMPILER_DIRECTIVE_OTHER = TextAttributesKey.createTextAttributesKey("GLSL.COMPILER_DIRECTIVE_OTHER", new TextAttributes(Color.GREEN.darker().darker(), null, null, null, Font.ITALIC));
    static final TextAttributesKey GLSL_UNKNOWN = TextAttributesKey.createTextAttributesKey("GLSL.UNKNOWN", new TextAttributes(Color.RED, null, null, null, Font.BOLD));

    public GLSLHighlighter() {
        super();
    }


    @NotNull
    public Lexer getHighlightingLexer() {
        return new GLSLFlexAdapter();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
        if (type == INTEGER_CONSTANT || type == FLOAT_CONSTANT || type == BOOL_CONSTANT) {
            return new TextAttributesKey[]{GLSL_NUMBER};
        } else if (type == COMMENT_BLOCK || type == COMMENT_LINE) {
            return new TextAttributesKey[]{GLSL_COMMENT};
        } else if (type == IDENTIFIER) {
            return new TextAttributesKey[]{GLSL_IDENTIFIER};
        } else if (type == COMPILER_DIRECTIVE_VERSION) {
            return new TextAttributesKey[]{GLSL_COMPILER_DIRECTIVE_VERSION};
        } else if (type == COMPILER_DIRECTIVE_EXTENSION) {
            return new TextAttributesKey[]{GLSL_COMPILER_DIRECTIVE_EXTENSION};
        } else if (type == COMPILER_DIRECTIVE_PRAGMA) {
            return new TextAttributesKey[]{GLSL_COMPILER_DIRECTIVE_PRAGMA};
        } else if (type == COMPILER_DIRECTIVE_OTHER) {
            return new TextAttributesKey[]{GLSL_COMPILER_DIRECTIVE_OTHER};
        } else if (TYPE_SPECIFIER_NONARRAY_TOKENS.contains(type)) {
            return new TextAttributesKey[]{GLSL_TYPE_SPECIFIER};
        } else if (QUALIFIER_TOKENS.contains(type)) {
            return new TextAttributesKey[]{GLSL_TYPE_QUALIFIERS};
        } else if (PARAMETER_QUALIFIERS.contains(type)) {
            return new TextAttributesKey[]{GLSL_PARAMETER_QUALIFIERS};
        } else if (FLOW_KEYWORDS.contains(type)) {
            return new TextAttributesKey[]{GLSL_FLOW_KEYWORDS};
        } else if (type == UNKNOWN) {
            return new TextAttributesKey[]{GLSL_UNKNOWN};
        }
        return new TextAttributesKey[]{TextAttributesKey.createTextAttributesKey("GLSL.TEXT", new TextAttributes(Color.BLACK, null, null, null, Font.PLAIN))};
    }
}
