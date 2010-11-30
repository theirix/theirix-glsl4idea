package glslplugin.annotation;

import com.intellij.lang.annotation.AnnotationHolder;

/**
 * GLSLAssignmentExpressionAnnotator is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Jan 30, 2009
 *         Time: 10:59:28 AM
 */
public interface Annotator<T> {
    void annotate(T expr, AnnotationHolder holder);
}
