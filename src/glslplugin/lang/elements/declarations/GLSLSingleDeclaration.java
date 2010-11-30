package glslplugin.lang.elements.declarations;

import org.jetbrains.annotations.NotNull;

/**
 * NewSingleDeclaration is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 12:44:53 PM
 */
public interface GLSLSingleDeclaration extends GLSLDeclaration {
    String getDeclaredName();

    @NotNull
    GLSLDeclarator getDeclarator();
}
