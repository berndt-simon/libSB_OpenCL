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
package libSB.openCL.model;

import libSB.openXL.model.TypeDefQualifier;
import com.jogamp.common.nio.Buffers;

/**
 *
 * @author Simon Berndt
 */
public enum CLBaseDataType implements TypeDefQualifier {

    // BOOL("bool", Buffers.SIZEOF_BYTE), 
    CHAR("char", Buffers.SIZEOF_CHAR),
    SHORT("short", Buffers.SIZEOF_SHORT), SHORT_2("short2", Buffers.SIZEOF_SHORT * 2), SHORT_3("short3", Buffers.SIZEOF_SHORT * 3), SHORT_4("short4", Buffers.SIZEOF_SHORT * 4),
    INT("int", Buffers.SIZEOF_INT), INT_2("int2", Buffers.SIZEOF_INT * 2), INT_3("int3", Buffers.SIZEOF_INT * 3), INT_4("int4", Buffers.SIZEOF_INT * 4),
    LONG("long", Buffers.SIZEOF_LONG), LONG_2("long2", Buffers.SIZEOF_LONG * 2), LONG_3("long3", Buffers.SIZEOF_LONG * 3), LONG_4("long4", Buffers.SIZEOF_LONG * 4),
    FLOAT("float", Buffers.SIZEOF_FLOAT), FLOAT_2("float2", Buffers.SIZEOF_FLOAT * 2), FLOAT_3("float3", Buffers.SIZEOF_FLOAT * 3), FLOAT_4("float4", Buffers.SIZEOF_FLOAT * 4),
    // HALF("half"), HALF_2("half2"), HALF_3("half3"), HALF_4("half4"),
    DOUBLE("double", Buffers.SIZEOF_DOUBLE), DOUBLE_2("double2", Buffers.SIZEOF_DOUBLE * 2), DOUBLE_3("double3", Buffers.SIZEOF_DOUBLE * 3), DOUBLE_4("double4", Buffers.SIZEOF_DOUBLE * 4);

    private final String typeDef;
    private final int bytes;

    private CLBaseDataType(String typeDef, int bytes) {
        this.typeDef = typeDef;
        this.bytes = bytes;
    }

    @Override
    public String getTypeDef() {
        return typeDef;
    }

    @Override
    public int getSizeOf() {
        return bytes;
    }

}
