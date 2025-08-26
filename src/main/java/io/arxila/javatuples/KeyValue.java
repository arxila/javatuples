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

/**
 * <p>
 * A specialization of a two-value tuple meant to store a label and a value.
 * </p> 
 * 
 * @since 2.0.0
 *
 */
public record KeyValue<K,V>(K key, V value) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1002919099724183705L;

    private static final int SIZE = 2;

    
    public static <X,Y> KeyValue<X,Y> of(final X key, final Y value) {
        return new KeyValue<>(key, value);
    }

    public static <X> KeyValue<X,X> of(final X[] keyValue) {
        if (keyValue == null) {
            throw new NullPointerException("keyValue is null");
        }
        if (keyValue.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + keyValue.length + ")");
        }
        return new KeyValue<>(keyValue[0], keyValue[1]);
    }

    public static <X> KeyValue<X,X> of(final List<X> keyValue) {
        if (keyValue == null) {
            throw new NullPointerException("keyValue is null");
        }
        if (keyValue.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + keyValue.size() + ")");
        }
        return new KeyValue<>(keyValue.get(0), keyValue.get(1));
    }


    public <K2> KeyValue<K2,V> withKey(final K2 key) {
        return new KeyValue<>(key, this.value);
    }

    public <V2> KeyValue<K,V2> withValue(final V2 value) {
        return new KeyValue<>(this.key, value);
    }

}
