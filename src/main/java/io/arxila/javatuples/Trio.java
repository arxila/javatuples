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
 * A tuple of three elements.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Trio<A,B,C>(A value0, B value1, C value2) implements Tuple {

    @Serial
    private static final long serialVersionUID = 7015864444752112655L;

    private static final int SIZE = 3;

    
    public static <A,B,C> Trio<A,B,C> of(final A value0, final B value1, final C value2) {
        return new Trio<>(value0, value1, value2);
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
            default -> throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        };
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0, this.value1, this.value2);
    }

    @Override
    public boolean contains(final Object o) {
        return (Objects.equals(this.value0, o)
                || Objects.equals(this.value1, o)
                || Objects.equals(this.value2, o));
    }


    public <X> Trio<X,B,C> withValue0(final X value0) {
        return new Trio<>(value0, this.value1, this.value2);
    }

    public <X> Trio<A,X,C> withValue1(final X value1) {
        return new Trio<>(this.value0, value1, this.value2);
    }

    public <X> Trio<A,B,X> withValue2(final X value2) {
        return new Trio<>(this.value0, this.value1, value2);
    }


    public <X> Quartet<A,B,C,X> withValue3(final X value3) {
        return new Quartet<>(this.value0, this.value1, this.value2, value3);
    }


    public Pair<B,C> withoutValue0() {
        return new Pair<>(this.value1, this.value2);
    }

    public Pair<A,C> withoutValue1() {
        return new Pair<>(this.value0, this.value2);
    }

    public Pair<A,B> withoutValue2() {
        return new Pair<>(this.value0, this.value1);
    }

}
