/*
 * The MIT License
 *
 * Copyright 2015 Simon Berndt.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package libSB.openCL.model.kernel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import libSB.openCL.model.method.MethodParameter;

/**
 *
 * @author Simon Berndt
 */
public class KernelDefinitionBuilder {

    private static final Logger LOG = Logger.getLogger(KernelDefinitionBuilder.class.getName());

    private final String kernelName;
    private final List<MethodParameter> parameters;

    KernelDefinitionBuilder(String typeDef) {
        this.kernelName = typeDef;
        this.parameters = new ArrayList<>();
    }

    public KernelDefinitionBuilder parameter(MethodParameter parameter) {
        if (parameters.contains(parameter)) {
            LOG.log(Level.WARNING, "KernelDefinition already contained the given Parameter");
        } else {
            parameters.add(parameter);
        }
        return this;
    }
    
    public KernelDefinition build() {
        List<MethodParameter> unmodifiableParameters = Collections.unmodifiableList(parameters);
        return new KernelDefinition(kernelName, unmodifiableParameters);
    }

}
