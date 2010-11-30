package glslplugin.lang.elements.reference;

import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.ResolveResult;
import glslplugin.lang.elements.GLSLElement;
import glslplugin.lang.elements.GLSLIdentifier;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLFunctionReference is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 1, 2009
 *         Time: 10:04:11 PM
 */
public class GLSLFunctionReference extends GLSLReferenceBase<GLSLIdentifier, GLSLElement>
        implements PsiPolyVariantReference {

    GLSLElement[] targets;

    public GLSLFunctionReference(GLSLIdentifier source, GLSLElement[] targets) {
        super(source, targets[0]);
        this.targets = targets;
    }

    @NotNull
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        ResolveResult[] result = new ResolveResult[targets.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new PsiElementResolveResult(targets[i]);
        }
        return result;
    }

    @Override
    public GLSLElement resolve() {
        if (targets.length == 1) {
            return target;
        } else {
            return null;
        }
    }
}
