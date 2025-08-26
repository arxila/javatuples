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
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * A specialization of a two-value tuple meant to store a map entry for {@link java.util.Map}, implementing
 * the {@link java.util.Map.Entry} interface.
 * </p>
 * <p>
 * Important: this is an immutable class, although the contained keys and values can be mutable.
 * </p>
 * 
 * @since 2.0.0
 *
 */
public record MapEntry<K,V>(K key, V value) implements Map.Entry<K,V>, Serializable {

    @Serial
    private static final long serialVersionUID = 7812612658461308051L;

    private static final int SIZE = 2;

    
    public static <X,Y> MapEntry<X,Y> of(final X key, final Y value) {
        return new MapEntry<>(key, value);
    }

    public static <X> MapEntry<X,X> of(final X[] keyValue) {
        if (keyValue == null) {
            throw new NullPointerException("keyValue is null");
        }
        if (keyValue.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + keyValue.length + ")");
        }
        return new MapEntry<>(keyValue[0], keyValue[1]);
    }

    public static <X> MapEntry<X,X> of(final List<X> keyValue) {
        if (keyValue == null) {
            throw new NullPointerException("keyValue is null");
        }
        if (keyValue.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + keyValue.size() + ")");
        }
        return new MapEntry<>(keyValue.get(0), keyValue.get(1));
    }


    public <K2> MapEntry<K2,V> withKey(final K2 key) {
        return new MapEntry<>(key, this.value);
    }

    public <V2> MapEntry<K,V2> withValue(final V2 value) {
        return new MapEntry<>(this.key, value);
    }


    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException("This map entry is immutable: use withValue() instead");
    }


    @Override
    public boolean equals(final Object other) {
        // Map.Entry requires equals() to apply to any implementation of the interface.
        if (!(other instanceof Map.Entry<?, ?> otherEntry)) {
            return false;
        }
        return Objects.equals(this.key, otherEntry.getKey()) && Objects.equals(this.value, otherEntry.getValue());

    }

    @Override
    public int hashCode() {
        return ((this.key == null) ? 0 : this.key.hashCode()) ^
                ((this.value == null) ? 0 : this.value.hashCode());
    }

}
