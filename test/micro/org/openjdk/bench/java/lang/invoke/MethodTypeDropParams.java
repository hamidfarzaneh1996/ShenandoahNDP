/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.openjdk.bench.java.lang.invoke;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.lang.invoke.MethodType;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark assesses the MethodType.dropParameterTypes()
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class MethodTypeDropParams {

    private MethodType mt;

    @Setup
    public void setup() {
        mt = MethodType.methodType(void.class, int.class, int.class, int.class);
    }

    @Benchmark
    public MethodType baselineRaw() {
        return mt;
    }

    @Benchmark
    public MethodType baselineSame() {
        return mt.dropParameterTypes(0, 0);
    }

    @Benchmark
    public MethodType testDrop_A1() {
        return mt.dropParameterTypes(0, 1);
    }

    @Benchmark
    public MethodType testDrop_A2() {
        return mt.dropParameterTypes(0, 2);
    }

    @Benchmark
    public MethodType testDrop_A3() {
        return mt.dropParameterTypes(0, 3);
    }

}
