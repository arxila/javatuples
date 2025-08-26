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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *   Base interface for all tuples.
 * </p>
 * <p>
 *   Comparison is based on the natural ordering of the elements and null-first.
 * </p>
 *
 * @since 2.0.0
 *
 */
public interface Tuple extends Iterable<Object>, Serializable {

    int size();

    Object value(int index);

    List<Object> values();

    boolean contains(final Object value);


    default boolean containsAll(final Collection<?> values) {
        for (final Object value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    default boolean containsAll(final Tuple tuple) {
        return containsAll(tuple.values());
    }

    default boolean containsAll(final Object... values) {
        for (final Object value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    default boolean containsAny(final Collection<?> values) {
        for (final Object value : values) {
            if (contains(value)) {
                return true;
            }
        }
        return false;
    }

    default boolean containsAny(final Tuple tuple) {
        return containsAny(tuple.values());
    }

    default boolean containsAny(final Object... values) {
        for (final Object value : values) {
            if (contains(value)) {
                return true;
            }
        }
        return false;
    }


    default int indexOf(final Object value) {
        final List<?> values = values();
        final int size = this.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values.get(i), value)) {
                return i;
            }
        }
        return -1;
    }

    default int lastIndexOf(final Object value) {
        final List<?> values = values();
        for (int i = this.size() - 1; i >= 0; i--) {
            if (Objects.equals(values.get(i), value)) {
                return i;
            }
        }
        return -1;
    }


    default List<Object> toList() {
        return this.values(); // already returns an immutable list
    }

    default Object[] toArray() {
        return this.values().toArray();
    }

    default <X> X[] toArray(final X[] a) {
        return this.values().toArray(a);
    }


    @Override
    default Iterator<Object> iterator() {
        return values().iterator();
    }

    default boolean equalsIgnoreOrder(final Tuple other) {

        if (this == other) {
            return true;
        }
        final int size = this.size();
        if (other == null || size != other.size()) {
            return false;
        }

        // Store every element along with the number of times it occurs, then use the other map to decrease
        final Map<Object, Integer> valueOccurrences = new HashMap<>(size + 1, 1.0f);

        for (int i = 0; i < size; i++) {
            final Object thisValue = this.value(i);
            valueOccurrences.merge(thisValue, 1, Integer::sum);
        }

        for (int i = 0; i < size; i++) {
            final Object otherValue = other.value(i);
            int occ = valueOccurrences.merge(otherValue, -1, Integer::sum);
            if (occ < 0) {
                return false; // element is not present: tuples are different
            } else if (occ == 0) {
                valueOccurrences.remove(otherValue);
            }
        }

        return valueOccurrences.isEmpty();
    }


}
