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
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
public interface Tuple extends Iterable<Object>, Serializable, Comparable<io.arxila.javatuples.Tuple> {

    int size();
    List<Object> values();

    default Object value(int index) {
        return values().get(index);
    }

    default boolean contains(final Object value) {
        return values().contains(value);
    }

    default boolean containsAll(final Collection<?> values) {
        // We don't fear using List#containsAll() because tuples are never larger than 10.
        // noinspection SlowListContainsAll
        return values().containsAll(values);
    }

    default boolean containsAll(final Tuple tuple) {
        return containsAll(tuple.values());
    }

    default boolean containsAll(final Object... values) {
        final List<Object> tupleValues = values();
        for (Object value : values) {
            if (!tupleValues.contains(value)) {
                return false;
            }
        }
        return true;
    }

    default boolean containsAny(final Collection<?> values) {
        final List<Object> tupleValues = values();
        for (Object value : values) {
            if (tupleValues.contains(value)) {
                return true;
            }
        }
        return false;
    }

    default boolean containsAny(final Tuple tuple) {
        return containsAny(tuple.values());
    }

    default boolean containsAny(final Object... values) {
        final List<Object> tupleValues = values();
        for (Object value : values) {
            if (tupleValues.contains(value)) {
                return true;
            }
        }
        return false;
    }

    default int indexOf(final Object value) {
        int i = 0;
        for (final Object val : values()) {
            if (val == null) {
                if (value == null) {
                    return i;
                }
            } else {
                if (val.equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    default int lastIndexOf(final Object value) {
        for (int i = this.size() - 1; i >= 0; i--) {
            final Object val = value(i);
            if (val == null) {
                if (value == null) {
                    return i;
                }
            } else {
                if (val.equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }


    default <X> List<X> toList(final Class<X> ofClass) {
        // noinspection unchecked
        return (List<X>) this.values(); // already returns an immutable list
    }

    default List<Object> toList() {
        return this.values(); // already returns an immutable list
    }

    default <X> X[] toArray(final Class<X> ofClass) {
        if (ofClass == null) {
            throw new NullPointerException("ofClass cannot be null");
        }
        // noinspection unchecked
        return this.values().toArray((X[]) Array.newInstance(ofClass, this.size()));
    }

    default Object[] toArray() {
        return this.values().toArray();
    }


    @Override
    default Iterator<Object> iterator() {
        return values().iterator();
    }

    default int compareTo(final Tuple other) {

        final List<Object> thisValues = this.values();
        final List<Object> otherValues = other.values();

        int minLength = Math.min(this.size(), other.size());

        for (int i = 0; i < minLength; i++) {

            final Object a = thisValues.get(i);
            final Object b = otherValues.get(i);

            // Null policy: nullsFirst
            if (a == b) { // covers both null and identical reference
                continue;
            }
            if (a == null) {
                return -1;
            }
            if (b == null) {
                return 1;
            }

            if (!(a instanceof Comparable)) {
                throw new ClassCastException(
                        "Tuple elements must implement Comparable, but element " + i +
                        " in tuple " + this.toString() + " does not.");
            }

            @SuppressWarnings("unchecked")
            int comparison = ((Comparable<Object>) a).compareTo(b);

            if (comparison != 0) {
                return comparison;
            }

        }

        // If all common elements are equal, the shorter tuple is considered smaller.
        return Integer.compare(this.size(), other.size());

    }

}
