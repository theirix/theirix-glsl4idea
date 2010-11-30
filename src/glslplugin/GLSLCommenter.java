package glslplugin;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

/**
 * Copyright (c) ${year} Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 13.sep.2008
 * Time: 10:50:49
 */
public class GLSLCommenter implements Commenter {
    @Nullable
    public String getLineCommentPrefix() {
        return "//";
    }

    @Nullable
    public String getBlockCommentPrefix() {
        return "/*";
    }

    @Nullable
    public String getBlockCommentSuffix() {
        return "*/";
    }

    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

    //todo: implement CodeDocumentationAwareCommenter... ??
}
