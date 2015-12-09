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
import java.util.Optional;
import java.util.OptionalInt;
import libSB.openCL.model.AddressSpaceQualifier;
import libSB.openXL.model.TypeDefQualifier;

/**
 *
 * @author Simon Berndt
 */
public class MethodParameter {

    private final AddressSpaceQualifier addressSpaceQualifier;
    private final TypeDefQualifier type;
    private final String identifier;
    private final boolean array;
    private final int pointer;

    MethodParameter(AddressSpaceQualifier addressSpaceQualifier, TypeDefQualifier type, int pointer, String identifier, boolean array) {
        this.addressSpaceQualifier = addressSpaceQualifier;
        this.type = type;
        this.identifier = identifier;
        this.array = array;
        this.pointer = pointer;
    }

    public Optional<AddressSpaceQualifier> getAddressSpaceQualifier() {
        return Optional.ofNullable(addressSpaceQualifier);
    }

    public TypeDefQualifier getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean isArray() {
        return array;
    }

    public OptionalInt getPointerLevel() {
        if (isPointer()) {
            return OptionalInt.of(pointer);
        }
        return OptionalInt.empty();
    }

    public boolean isPointer() {
        return pointer > 0;
    }
    
    public static MethodParameterBuilder builder(TypeDefQualifier typeDefQualifier, String identifier) {
        Objects.requireNonNull(typeDefQualifier);
        Objects.requireNonNull(identifier);
        return new MethodParameterBuilder(typeDefQualifier, identifier);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.identifier);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MethodParameter other = (MethodParameter) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        return true;
    }
    
    

}
