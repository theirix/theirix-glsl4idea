package glslplugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import glslplugin.lang.elements.GLSLTokenTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Todo: Blocks. Must have a PSI tree implemented...
 *
 * Copyright (c) 2008 Jean-Paul Balabanian
 * User: jeanpaul
 * Date: 13.sep.2008
 * Time: 22:55:26
 */
public class GLSLFoldingBuilder implements FoldingBuilder {
    public FoldingDescriptor[] buildFoldRegions(ASTNode node, Document document) {
        List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
        appendDescriptors(node, document, descriptors);
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    private void appendDescriptors(final ASTNode node, final Document document, final List<FoldingDescriptor> descriptors) {
        if (node.getElementType() == GLSLTokenTypes.COMMENT_BLOCK) {
            //todo: check if inside or outside method
            descriptors.add(new FoldingDescriptor(node, node.getTextRange()));
        } 

        ASTNode child = node.getFirstChildNode();
        while (child != null) {
            appendDescriptors(child, document, descriptors);
            child = child.getTreeNext();
        }
    }

    public String getPlaceholderText(ASTNode node) {
        if (node.getElementType() == GLSLTokenTypes.COMMENT_BLOCK) {
            return "/*...*/";
        }
        return null;
    }

    public boolean isCollapsedByDefault(ASTNode astNode) {
        return false;
    }
}
