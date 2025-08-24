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
 * A tuple of five elements.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Quintet<A,B,C,D,E>(A value0, B value1, C value2, D value3, E value4) implements Tuple {

    @Serial
    private static final long serialVersionUID = 7939249598771928934L;

    private static final int SIZE = 5;

    
    public static <A,B,C,D,E> Quintet<A,B,C,D,E> of(
            final A value0, final B value1, final C value2, final D value3, final E value4) {
        return new Quintet<>(value0, value1, value2, value3, value4);
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


    public <X> Quintet<X,B,C,D,E> withValue0(final X value0) {
        return new Quintet<>(value0, this.value1, this.value2, this.value3, this.value4);
    }

    public <X> Quintet<A,X,C,D,E> withValue1(final X value1) {
        return new Quintet<>(this.value0, value1, this.value2, this.value3, this.value4);
    }

    public <X> Quintet<A,B,X,D,E> withValue2(final X value2) {
        return new Quintet<>(this.value0, this.value1, value2, this.value3, this.value4);
    }

    public <X> Quintet<A,B,C,X,E> withValue3(final X value3) {
        return new Quintet<>(this.value0, this.value1, this.value2, value3, this.value4);
    }

    public <X> Quintet<A,B,C,D,X> withValue4(final X value4) {
        return new Quintet<>(this.value0, this.value1, this.value2, this.value3, value4);
    }


    public <X> Sextet<A,B,C,D,E,X> withValue5(final X value5) {
        return new Sextet<>(this.value0, this.value1, this.value2, this.value3, this.value4, value5);
    }


    public Quartet<B,C,D,E> withoutValue0() {
        return new Quartet<>(this.value1, this.value2, this.value3, this.value4);
    }

    public Quartet<A,C,D,E> withoutValue1() {
        return new Quartet<>(this.value0, this.value2, this.value3, this.value4);
    }

    public Quartet<A,B,D,E> withoutValue2() {
        return new Quartet<>(this.value0, this.value1, this.value3, this.value4);
    }

    public Quartet<A,B,C,E> withoutValue3() {
        return new Quartet<>(this.value0, this.value1, this.value2, this.value4);
    }

    public Quartet<A,B,C,D> withoutValue4() {
        return new Quartet<>(this.value0, this.value1, this.value2, this.value3);
    }

}
