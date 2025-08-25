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
 * A tuple of two elements.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Pair<A,B>(A value0, B value1) implements Tuple {

    @Serial
    private static final long serialVersionUID = 8000659993742639181L;

    private static final int SIZE = 2;

    
    public static <X,Y> Pair<X,Y> of(final X value0, final Y value1) {
        return new Pair<>(value0, value1);
    }

    public static <X> Pair<X,X> of(final X[] values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.length + ")");
        }
        return new Pair<>(values[0], values[1]);
    }

    public static <X> Pair<X,X> of(final List<X> values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.size() + ")");
        }
        return new Pair<>(values.get(0), values.get(1));
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
            default -> throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        };
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0, this.value1);
    }

    @Override
    public boolean contains(final Object o) {
        return (Objects.equals(this.value0, o)
                || Objects.equals(this.value1, o));
    }


    public <X> Pair <X,B> withValue0(final X value0) {
        return new Pair<>(value0, this.value1);
    }

    public <X> Pair <A,X> withValue1(final X value1) {
        return new Pair<>(this.value0, value1);
    }


    public <X> Trio<A,B,X> withValue2(final X value2) {
        return new Trio<>(this.value0, this.value1, value2);
    }


    public Solo<B> withoutValue0() {
        return new Solo<>(this.value1);
    }

    public Solo<A> withoutValue1() {
        return new Solo<>(this.value0);
    }

}
