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
public record LabelValue<K,V>(K label, V value) implements Serializable {

    @Serial
    private static final long serialVersionUID = -2526576869403695502L;

    private static final int SIZE = 2;

    
    public static <X,Y> LabelValue<X,Y> of(final X label, final Y value) {
        return new LabelValue<>(label, value);
    }

    public static <X> LabelValue<X,X> of(final X[] labelValue) {
        if (labelValue == null) {
            throw new NullPointerException("labelValue is null");
        }
        if (labelValue.length != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + labelValue.length + ")");
        }
        return new LabelValue<>(labelValue[0], labelValue[1]);
    }

    public static <X> LabelValue<X,X> of(final List<X> labelValue) {
        if (labelValue == null) {
            throw new NullPointerException("labelValue is null");
        }
        if (labelValue.size() != SIZE) {
            throw new IllegalArgumentException("Expected size " + SIZE + " (but was:  " + labelValue.size() + ")");
        }
        return new LabelValue<>(labelValue.get(0), labelValue.get(1));
    }


    public <K2> LabelValue<K2,V> withLabel(final K2 label) {
        return new LabelValue<>(label, this.value);
    }

    public <V2> LabelValue<K,V2> withValue(final V2 value) {
        return new LabelValue<>(this.label, value);
    }

}
