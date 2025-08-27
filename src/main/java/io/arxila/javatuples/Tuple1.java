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
 * A tuple of one element. Numbered equivalent to {@link Solo}.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Tuple1<A>(A value0) implements Tuple {

    @Serial
    private static final long serialVersionUID = 7318579307209871888L;

    private static final int SIZE = 1;


    public static <X> Tuple1<X> of(final X value0) {
        return new Tuple1<>(value0);
    }

    public static <X> Tuple1<X> of(final X[] values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.length + ")");
        }
        return new Tuple1<>(values[0]);
    }

    public static <X> Tuple1<X> of(final List<X> values) {
        if (values == null) {
            throw new NullPointerException("values is null");
        }
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + values.size() + ")");
        }
        return new Tuple1<>(values.get(0));
    }


    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public Object value(final int index) {
        if (index == 0) {
            return this.value0;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
    }

    @Override
    public List<Object> values() {
        return List.of(this.value0);
    }

    @Override
    public boolean contains(final Object o) {
        return Objects.equals(this.value0, o);
    }


    public <X> Tuple1<X> withValue0(final X value0) {
        return new Tuple1<>(value0);
    }


    public <X> Tuple2<A,X> withValue1(final X value1) {
        return new Tuple2<>(this.value0, value1);
    }


    public Tuple0 withoutValue0() {
        return new Tuple0();
    }

}
