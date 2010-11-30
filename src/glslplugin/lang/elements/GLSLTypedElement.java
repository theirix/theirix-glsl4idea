package glslplugin.lang.elements;

import glslplugin.lang.elements.types.GLSLType;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLTypedElement is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 27, 2009
 *         Time: 11:39:39 AM
 */
public interface GLSLTypedElement extends GLSLElement {
    @NotNull
    GLSLType getType();
}
