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

import com.intellij.lang.ASTNode;
import glslplugin.lang.elements.expressions.GLSLExpression;
import glslplugin.lang.elements.types.GLSLBasicFunctionType;
import glslplugin.lang.elements.types.GLSLFunctionType;
import glslplugin.lang.elements.types.GLSLType;
import glslplugin.lang.elements.types.GLSLTypeCompatibilityLevel;
import org.jetbrains.annotations.NotNull;

/**
 * GLSLFunctionDeclarationImpl is ...
 *
 * @author Yngve Devik Hammersland
 *         Date: Feb 2, 2009
 *         Time: 12:27:15 PM
 */
public class GLSLFunctionDeclarationImpl extends GLSLSingleDeclarationImpl implements GLSLFunctionDeclaration {
    private GLSLFunctionType type;

    public GLSLFunctionDeclarationImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @NotNull
    public GLSLParameterDeclaration[] getParameters() {
        GLSLDeclaration[] declarations = getParameterList().getDeclarations();
        return castToParameters(declarations);
    }

    @NotNull
    public GLSLDeclarationList getParameterList() {
        final GLSLDeclarationList list = findChildByClass(GLSLDeclarationList.class);
        assert list != null;
        return list;
    }

    public GLSLTypeCompatibilityLevel getParameterCompatibliltyLevel(GLSLExpression[] parameters) {
        final GLSLParameterDeclaration[] declaredParameters = getParameters();

        GLSLType[] types = new GLSLType[parameters.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = parameters[i].getType();
        }

        return getType().getParameterCompatibilityLevel(types);
    }

    private static GLSLParameterDeclaration[] castToParameters(GLSLDeclaration[] declarations) {
        GLSLParameterDeclaration[] parameters = new GLSLParameterDeclaration[declarations.length];
        for (int i = 0; i < declarations.length; i++) {
            parameters[i] = (GLSLParameterDeclaration) declarations[i];
        }
        return parameters;
    }

    @NotNull
    public String getSignature() {
        StringBuilder b = new StringBuilder();
        b.append(getDeclaredName()).append("(");
        boolean first = true;
        for (GLSLParameterDeclaration declarator : getParameters()) {
            if (!first) {
                b.append(",");
            }
            first = false;
            b.append(declarator.getTypeSpecifierNode().getTypeName());
        }
        b.append(") : ");
        b.append(getTypeSpecifierNode().getTypeName());
        return b.toString();
    }

    @Override
    public String toString() {
        return "Function Declaration: " + getSignature();
    }

    @NotNull
    public GLSLFunctionType getType() {
        if (type == null) {
            type = createType();
        }
        return type;
    }

    private GLSLFunctionType createType() {
        return new GLSLBasicFunctionType(this);
    }
}
