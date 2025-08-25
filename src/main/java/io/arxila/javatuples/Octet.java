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
 * A tuple of eight elements.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Octet<A,B,C,D,E,F,G,H>(
        A value0, B value1, C value2, D value3, E value4, F value5, G value6, H value7) implements Tuple {

    @Serial
    private static final long serialVersionUID = 7468281784575360602L;

    private static final int SIZE = 8;

    
    public static <A,B,C,D,E,F,G,H> Octet<A,B,C,D,E,F,G,H> of(
            final A value0, final B value1, final C value2, final D value3, final E value4,
            final F value5, final G value6, final H value7) {
        return new Octet<>(value0, value1, value2, value3, value4, value5, value6, value7);
    }

    public static <X> Octet<X,X,X,X,X,X,X,X> of(final X[] values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.length + ")");
        }
        return new Octet<>(values[0], values[1], values[2], values[3], values[4],
                           values[5], values[6], values[7]);
    }

    public static <X> Octet<X,X,X,X,X,X,X,X> of(final List<X> values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.size() + ")");
        }
        return new Octet<>(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4),
                           values.get(5), values.get(6), values.get(7));
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
            case 5 -> this.value5;
            case 6 -> this.value6;
            case 7 -> this.value7;
            default -> throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        };
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0, this.value1, this.value2, this.value3, this.value4,
                       this.value5, this.value6, this.value7);
    }

    @Override
    public boolean contains(final Object o) {
        return (Objects.equals(this.value0, o)
                || Objects.equals(this.value1, o)
                || Objects.equals(this.value2, o)
                || Objects.equals(this.value3, o)
                || Objects.equals(this.value4, o)
                || Objects.equals(this.value5, o)
                || Objects.equals(this.value6, o)
                || Objects.equals(this.value7, o));
    }


    public <X> Octet<X,B,C,D,E,F,G,H> withValue0(final X value0) {
        return new Octet<>(value0, this.value1, this.value2, this.value3, this.value4, this.value5,
                           this.value6, this.value7);
    }

    public <X> Octet<A,X,C,D,E,F,G,H> withValue1(final X value1) {
        return new Octet<>(this.value0, value1, this.value2, this.value3, this.value4, this.value5,
                           this.value6, this.value7);
    }

    public <X> Octet<A,B,X,D,E,F,G,H> withValue2(final X value2) {
        return new Octet<>(this.value0, this.value1, value2, this.value3, this.value4, this.value5,
                           this.value6, this.value7);
    }

    public <X> Octet<A,B,C,X,E,F,G,H> withValue3(final X value3) {
        return new Octet<>(this.value0, this.value1, this.value2, value3, this.value4, this.value5,
                           this.value6, this.value7);
    }

    public <X> Octet<A,B,C,D,X,F,G,H> withValue4(final X value4) {
        return new Octet<>(this.value0, this.value1, this.value2, this.value3, value4, this.value5,
                           this.value6, this.value7);
    }

    public <X> Octet<A,B,C,D,E,X,G,H> withValue5(final X value5) {
        return new Octet<>(this.value0, this.value1, this.value2, this.value3, this.value4, value5,
                           this.value6, this.value7);
    }

    public <X> Octet<A,B,C,D,E,F,X,H> withValue6(final X value6) {
        return new Octet<>(this.value0, this.value1, this.value2, this.value3, this.value4, this.value5,
                           value6, this.value7);
    }

    public <X> Octet<A,B,C,D,E,F,G,X> withValue7(final X value7) {
        return new Octet<>(this.value0, this.value1, this.value2, this.value3, this.value4, this.value5,
                           this.value6, value7);
    }


    public <X> Nonet<A,B,C,D,E,F,G,H,X> withValue8(final X value8) {
        return new Nonet<>(this.value0, this.value1, this.value2, this.value3, this.value4, this.value5,
                           this.value6, this.value7, value8);
    }


    public Septet<B,C,D,E,F,G,H> withoutValue0() {
        return new Septet<>(this.value1, this.value2, this.value3, this.value4, this.value5,
                            this.value6, this.value7);
    }

    public Septet<A,C,D,E,F,G,H> withoutValue1() {
        return new Septet<>(this.value0, this.value2, this.value3, this.value4, this.value5,
                            this.value6, this.value7);
    }

    public Septet<A,B,D,E,F,G,H> withoutValue2() {
        return new Septet<>(this.value0, this.value1, this.value3, this.value4, this.value5,
                            this.value6, this.value7);
    }

    public Septet<A,B,C,E,F,G,H> withoutValue3() {
        return new Septet<>(this.value0, this.value1, this.value2, this.value4, this.value5,
                            this.value6, this.value7);
    }

    public Septet<A,B,C,D,F,G,H> withoutValue4() {
        return new Septet<>(this.value0, this.value1, this.value2, this.value3, this.value5,
                            this.value6, this.value7);
    }

    public Septet<A,B,C,D,E,G,H> withoutValue5() {
        return new Septet<>(this.value0, this.value1, this.value2, this.value3, this.value4,
                            this.value6, this.value7);
    }

    public Septet<A,B,C,D,E,F,H> withoutValue6() {
        return new Septet<>(this.value0, this.value1, this.value2, this.value3, this.value4,
                            this.value5, this.value7);
    }

    public Septet<A,B,C,D,E,F,G> withoutValue7() {
        return new Septet<>(this.value0, this.value1, this.value2, this.value3, this.value4,
                            this.value5, this.value6);
    }

}
