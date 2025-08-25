/*
 * =========================================================================
 *
 *   Copyright (c) 2010-2025 Arxila OSS (https://arxila.io)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *   implied. See the License for the specific language governing
 *   permissions and limitations under the License.
 *
 * =========================================================================
 */
package io.arxila.javatuples;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * A tuple of four elements.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Quartet<A,B,C,D>(A value0, B value1, C value2, D value3) implements Tuple {

    @Serial
    private static final long serialVersionUID = -4368514251963327633L;

    private static final int SIZE = 4;

    
    public static <A,B,C,D> Quartet<A,B,C,D> of(final A value0, final B value1, final C value2, final D value3) {
        return new Quartet<>(value0, value1, value2, value3);
    }

    public static <X> Quartet<X,X,X,X> of(final X[] values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.length + ")");
        }
        return new Quartet<>(values[0], values[1], values[2], values[3]);
    }

    public static <X> Quartet<X,X,X,X> of(final List<X> values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.size() + ")");
        }
        return new Quartet<>(values.get(0), values.get(1), values.get(2), values.get(3));
    }


    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public Object value(final int index) {
        return switch (index) {
            case 0 -> this.value0;
            case 1 -> this.value1;
            case 2 -> this.value2;
            case 3 -> this.value3;
            default -> throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        };
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0, this.value1, this.value2, this.value3);
    }

    @Override
    public boolean contains(final Object o) {
        return (Objects.equals(this.value0, o)
                || Objects.equals(this.value1, o)
                || Objects.equals(this.value2, o)
                || Objects.equals(this.value3, o));
    }


    public <X> Quartet<X,B,C,D> withValue0(final X value0) {
        return new Quartet<>(value0, this.value1, this.value2, this.value3);
    }

    public <X> Quartet<A,X,C,D> withValue1(final X value1) {
        return new Quartet<>(this.value0, value1, this.value2, this.value3);
    }

    public <X> Quartet<A,B,X,D> withValue2(final X value2) {
        return new Quartet<>(this.value0, this.value1, value2, this.value3);
    }

    public <X> Quartet<A,B,C,X> withValue3(final X value3) {
        return new Quartet<>(this.value0, this.value1, this.value2, value3);
    }


    public <X> Quintet<A,B,C,D,X> withValue4(final X value4) {
        return new Quintet<>(this.value0, this.value1, this.value2, this.value3, value4);
    }


    public Trio<B,C,D> withoutValue0() {
        return new Trio<>(this.value1, this.value2, this.value3);
    }

    public Trio<A,C,D> withoutValue1() {
        return new Trio<>(this.value0, this.value2, this.value3);
    }

    public Trio<A,B,D> withoutValue2() {
        return new Trio<>(this.value0, this.value1, this.value3);
    }

    public Trio<A,B,C> withoutValue3() {
        return new Trio<>(this.value0, this.value1, this.value2);
    }

}
