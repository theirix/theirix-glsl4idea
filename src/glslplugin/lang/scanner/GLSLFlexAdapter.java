package glslplugin.lang.scanner;

import com.intellij.lexer.FlexAdapter;

/**
 * Copyright (c) ${year} Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 13.sep.2008
 * Time: 15:21:54
 */
public class GLSLFlexAdapter extends FlexAdapter {
    public GLSLFlexAdapter() {
        super(new GLSLFlexLexer((java.io.Reader) null));
    }
}
