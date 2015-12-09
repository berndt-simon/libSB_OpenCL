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
package libSB.openCL.util;

import java.util.Arrays;
import java.util.OptionalInt;
import libSB.openCL.model.kernel.KernelDefinition;
import libSB.openXL.model.struct.Struct;
import libSB.openXL.model.field.Field;
import libSB.openXL.util.AbstractCodeBuilder;

/**
 *
 * @author Simon Berndt
 */
public class OpenCLCodeBuilder extends AbstractCodeBuilder {

    public OpenCLCodeBuilder(StringBuilder code) {
        super(code);
    }

    public void typeDef(Struct struct, boolean packed) {
        code.append("typedef struct ");
        if (packed) {
            code.append("__attribute__((packed)) ");
        }
        code.append("{").append(NL);

        for (int i = 0; i < struct.getFields().size(); i++) {
            final Field field = struct.getFields().get(i);
            code.append(TAB).append(field.getType().getTypeDef()).append(' ');
            final OptionalInt pointerLevel = field.getPointerLevel();
            if (pointerLevel.isPresent()) {
                for (int p = 0; p < pointerLevel.getAsInt(); p++) {
                    code.append('*');
                }
            }
            code.append(field.getIdentifier());
            final OptionalInt arraySize = field.getArraySize();
            if (arraySize.isPresent()) {
                code.append('[').append(arraySize.getAsInt()).append(']');
            }
            code.append(';').append(NL);
        }

        code.append("} ").append(struct.getTypeDef()).append(";").append(NL);
    }
    
    public void kernel(KernelDefinition kernelDefinition, String kernelCode, boolean indentCode) {
        code.append("__kernel void ").append(kernelDefinition.getKernelName()).append('(');
        code.append(") {").append(NL);
        if (indentCode) {
            Arrays.stream(kernelCode.split(NL)).forEach((String line) -> {
                code.append(TAB).append(line).append(NL);
            });
        } else {
            code.append(kernelCode).append(NL);
        }
        code.append('}').append(NL);
    }

}
