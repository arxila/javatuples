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
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * A tuple of zero elements. Named equivalent to {@link Tuple0}.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record Empty() implements Tuple {

    @Serial
    private static final long serialVersionUID = 2762955134451185970L;

    private static final int SIZE = 0;


    public static Empty of() {
        return new Empty();
    }


    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public Object value(final int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
    }

    @Override
    public List<Object> values() {
        return Collections.emptyList();
    }

    @Override
    public boolean contains(final Object o) {
        return false;
    }


    public <X> Solo<X> withValue0(final X value0) {
        return new Solo<>(value0);
    }

}
