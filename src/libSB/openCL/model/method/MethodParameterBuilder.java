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
package libSB.openCL.model.method;

import java.util.Objects;
import libSB.openCL.model.AddressSpaceQualifier;
import libSB.openXL.model.TypeDefQualifier;

/**
 *
 * @author Simon Berndt
 */
public final class MethodParameterBuilder {

    private final TypeDefQualifier dataType;
    private final String identifier;
    private AddressSpaceQualifier addressSpaceQualifier;
    private int pointer;
    private boolean array;

    MethodParameterBuilder(TypeDefQualifier typeDefQualifier, String identifier) {
        this.dataType = typeDefQualifier;
        this.identifier = identifier;
        this.addressSpaceQualifier = null;
        this.pointer = 0;
        this.array = false;
    }

    /**
     * shortcut for pointer(1);
     */
    public MethodParameterBuilder pointer() {
        return pointer(1);
    }

    public MethodParameterBuilder pointer(int pointerLevel) {
        if (pointerLevel < 0) {
            throw new IllegalArgumentException("Pointer-Level can't be negative");
        }
        this.pointer = pointerLevel;
        return this;
    }

    public MethodParameterBuilder array() {
        this.array = true;
        return this;
    }
    
    public MethodParameterBuilder addressSpaceQualifier(AddressSpaceQualifier addressSpaceQualifier) {
        this.addressSpaceQualifier = Objects.requireNonNull(addressSpaceQualifier);
        return this;
    }

    public MethodParameter build() {
        return new MethodParameter(addressSpaceQualifier, dataType, pointer, identifier, array);
    }

}
