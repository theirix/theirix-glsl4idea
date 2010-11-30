package glslplugin.lang.elements;

import glslplugin.GLSLSupportLoader;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 14.sep.2008
 * Time: 17:22:27
 */
public class GLSLElementType extends com.intellij.psi.tree.IElementType {
    public GLSLElementType(@NotNull @NonNls String s) {
        super(s, GLSLSupportLoader.GLSL.getLanguage());
    }
}
