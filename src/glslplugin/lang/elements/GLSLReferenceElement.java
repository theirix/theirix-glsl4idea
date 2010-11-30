package glslplugin.lang.elements;

import com.intellij.psi.PsiReference;

/**
 * GLSLReferenceElement acts as a proxy for getReference and getReferences of PsiElement.
 * <p/>
 * This interface is implemented for those classes which references some kind definitions
 * but also needs IntelliJ IDEA to be unaware of that fact.
 * <p/>
 * <strong>Example:</strong> <br/>
 * The GLSLIdentifier element is the element we want IDEA to query for references, but it is the
 * GLSLCallExpression, GLSLIdentifierExpression, etc... which implements the functionality.
 *
 * @author Yngve Devik Hammersland
 *         Date: Mar 1, 2009
 *         Time: 10:52:06 PM
 */
public interface GLSLReferenceElement extends GLSLElement {
    PsiReference getReferenceProxy();
}
