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
 * A tuple of seven elements. Numbered equivalent to {@link Septet}.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Tuple7<A,B,C,D,E,F,G>(
        A value0, B value1, C value2, D value3, E value4, F value5, G value6) implements Tuple {

    @Serial
    private static final long serialVersionUID = 3301138490677507065L;

    private static final int SIZE = 7;

    
    public static <A,B,C,D,E,F,G> Tuple7<A,B,C,D,E,F,G> of(
            final A value0, final B value1, final C value2, final D value3, final E value4,
            final F value5, final G value6) {
        return new Tuple7<>(value0, value1, value2, value3, value4, value5, value6);
    }

    public static <X> Tuple7<X,X,X,X,X,X,X> of(final X[] values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.length + ")");
        }
        return new Tuple7<>(values[0], values[1], values[2], values[3], values[4],
                            values[5], values[6]);
    }

    public static <X> Tuple7<X,X,X,X,X,X,X> of(final List<X> values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.size() + ")");
        }
        return new Tuple7<>(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4),
                            values.get(5), values.get(6));
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
            default -> throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        };
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0, this.value1, this.value2, this.value3, this.value4, this.value5, this.value6);
    }

    @Override
    public boolean contains(final Object o) {
        return (Objects.equals(this.value0, o)
                || Objects.equals(this.value1, o)
                || Objects.equals(this.value2, o)
                || Objects.equals(this.value3, o)
                || Objects.equals(this.value4, o)
                || Objects.equals(this.value5, o)
                || Objects.equals(this.value6, o));
    }


    public <X> Tuple7<X,B,C,D,E,F,G> withValue0(final X value0) {
        return new Tuple7<>(value0, this.value1, this.value2, this.value3, this.value4, this.value5, this.value6);
    }

    public <X> Tuple7<A,X,C,D,E,F,G> withValue1(final X value1) {
        return new Tuple7<>(this.value0, value1, this.value2, this.value3, this.value4, this.value5, this.value6);
    }

    public <X> Tuple7<A,B,X,D,E,F,G> withValue2(final X value2) {
        return new Tuple7<>(this.value0, this.value1, value2, this.value3, this.value4, this.value5, this.value6);
    }

    public <X> Tuple7<A,B,C,X,E,F,G> withValue3(final X value3) {
        return new Tuple7<>(this.value0, this.value1, this.value2, value3, this.value4, this.value5, this.value6);
    }

    public <X> Tuple7<A,B,C,D,X,F,G> withValue4(final X value4) {
        return new Tuple7<>(this.value0, this.value1, this.value2, this.value3, value4, this.value5, this.value6);
    }

    public <X> Tuple7<A,B,C,D,E,X,G> withValue5(final X value5) {
        return new Tuple7<>(this.value0, this.value1, this.value2, this.value3, this.value4, value5, this.value6);
    }

    public <X> Tuple7<A,B,C,D,E,F,X> withValue6(final X value6) {
        return new Tuple7<>(this.value0, this.value1, this.value2, this.value3, this.value4, this.value5, value6);
    }


    public <X> Tuple8<A,B,C,D,E,F,G,X> withValue7(final X value7) {
        return new Tuple8<>(this.value0, this.value1, this.value2, this.value3, this.value4,
                           this.value5, this.value6, value7);
    }


    public Tuple6<B,C,D,E,F,G> withoutValue0() {
        return new Tuple6<>(this.value1, this.value2, this.value3, this.value4, this.value5, this.value6);
    }

    public Tuple6<A,C,D,E,F,G> withoutValue1() {
        return new Tuple6<>(this.value0, this.value2, this.value3, this.value4, this.value5, this.value6);
    }

    public Tuple6<A,B,D,E,F,G> withoutValue2() {
        return new Tuple6<>(this.value0, this.value1, this.value3, this.value4, this.value5, this.value6);
    }

    public Tuple6<A,B,C,E,F,G> withoutValue3() {
        return new Tuple6<>(this.value0, this.value1, this.value2, this.value4, this.value5, this.value6);
    }

    public Tuple6<A,B,C,D,F,G> withoutValue4() {
        return new Tuple6<>(this.value0, this.value1, this.value2, this.value3, this.value5, this.value6);
    }

    public Tuple6<A,B,C,D,E,G> withoutValue5() {
        return new Tuple6<>(this.value0, this.value1, this.value2, this.value3, this.value4, this.value6);
    }

    public Tuple6<A,B,C,D,E,F> withoutValue6() {
        return new Tuple6<>(this.value0, this.value1, this.value2, this.value3, this.value4, this.value5);
    }

}
