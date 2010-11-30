/*
 *     Copyright 2010 Jean-Paul Balabanian and Yngve Devik Hammersland
 *
 *     This file is part of glsl4idea.
 *
 *     Glsl4idea is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as
 *     published by the Free Software Foundation, either version 3 of
 *     the License, or (at your option) any later version.
 *
 *     Glsl4idea is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with glsl4idea.  If not, see <http://www.gnu.org/licenses/>.
 */

package glslplugin.lang.elements.declarations;

import glslplugin.lang.elements.GLSLTypedElement;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.types.GLSLFunctionType;
import glslplugin.lang.elements.types.GLSLTypeCompatibilityLevel;

/**
 * NewFunctionDeclaration represents a function declaration.
 * It inherits the name, qualifier and (return) type from {@link glslplugin.lang.elements.declarations.GLSLDeclaration} and adds the parameter list.
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 1:17:34 AM
 */
public interface GLSLFunctionDeclaration extends GLSLSingleDeclaration, GLSLTypedElement {

    GLSLParameterDeclaration[] getParameters();

    GLSLDeclarationList getParameterList();

    GLSLTypeCompatibilityLevel getParameterCompatibliltyLevel(GLSLExpression[] parameters);

    String getSignature();

    GLSLFunctionType getType();
}
