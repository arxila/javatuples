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
 * A tuple of five elements. Numbered equivalent to {@link Quintet}.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Tuple5<A,B,C,D,E>(A value0, B value1, C value2, D value3, E value4) implements Tuple {

    @Serial
    private static final long serialVersionUID = -9053112381798035975L;

    private static final int SIZE = 5;

    
    public static <A,B,C,D,E> Tuple5<A,B,C,D,E> of(
            final A value0, final B value1, final C value2, final D value3, final E value4) {
        return new Tuple5<>(value0, value1, value2, value3, value4);
    }

    public static <X> Tuple5<X,X,X,X,X> of(final X[] values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.length + ")");
        }
        return new Tuple5<>(values[0], values[1], values[2], values[3], values[4]);
    }

    public static <X> Tuple5<X,X,X,X,X> of(final List<X> values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.size() + ")");
        }
        return new Tuple5<>(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
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
            case 4 -> this.value4;
            default -> throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        };
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0, this.value1, this.value2, this.value3, this.value4);
    }

    @Override
    public boolean contains(final Object o) {
        return (Objects.equals(this.value0, o)
                || Objects.equals(this.value1, o)
                || Objects.equals(this.value2, o)
                || Objects.equals(this.value3, o)
                || Objects.equals(this.value4, o));
    }


    public <X> Tuple5<X,B,C,D,E> withValue0(final X value0) {
        return new Tuple5<>(value0, this.value1, this.value2, this.value3, this.value4);
    }

    public <X> Tuple5<A,X,C,D,E> withValue1(final X value1) {
        return new Tuple5<>(this.value0, value1, this.value2, this.value3, this.value4);
    }

    public <X> Tuple5<A,B,X,D,E> withValue2(final X value2) {
        return new Tuple5<>(this.value0, this.value1, value2, this.value3, this.value4);
    }

    public <X> Tuple5<A,B,C,X,E> withValue3(final X value3) {
        return new Tuple5<>(this.value0, this.value1, this.value2, value3, this.value4);
    }

    public <X> Tuple5<A,B,C,D,X> withValue4(final X value4) {
        return new Tuple5<>(this.value0, this.value1, this.value2, this.value3, value4);
    }


    public <X> Tuple6<A,B,C,D,E,X> withValue5(final X value5) {
        return new Tuple6<>(this.value0, this.value1, this.value2, this.value3, this.value4, value5);
    }


    public Tuple4<B,C,D,E> withoutValue0() {
        return new Tuple4<>(this.value1, this.value2, this.value3, this.value4);
    }

    public Tuple4<A,C,D,E> withoutValue1() {
        return new Tuple4<>(this.value0, this.value2, this.value3, this.value4);
    }

    public Tuple4<A,B,D,E> withoutValue2() {
        return new Tuple4<>(this.value0, this.value1, this.value3, this.value4);
    }

    public Tuple4<A,B,C,E> withoutValue3() {
        return new Tuple4<>(this.value0, this.value1, this.value2, this.value4);
    }

    public Tuple4<A,B,C,D> withoutValue4() {
        return new Tuple4<>(this.value0, this.value1, this.value2, this.value3);
    }

}
