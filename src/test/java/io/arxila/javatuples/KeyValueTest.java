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

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KeyValueTest {

    @Test
    void testOfAndAccess() {
        var kv = KeyValue.of("k", 123);
        assertEquals("k", kv.key());
        assertEquals(123, kv.value());
    }

    @Test
    void testOfArrayValidation() {
        assertThrows(NullPointerException.class, () -> KeyValue.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> KeyValue.of(new Object[]{}));
        assertThrows(IllegalArgumentException.class, () -> KeyValue.of(new Object[]{"k", 1, "extra"}));
    }

    @Test
    void testOfListValidation() {
        assertThrows(NullPointerException.class, () -> KeyValue.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> KeyValue.of(List.of()));
        assertThrows(IllegalArgumentException.class, () -> KeyValue.of(List.of("k", 1, "extra")));
    }

    @Test
    void testWithKey() {
        var kv = KeyValue.of("k", 123);
        var kv2 = kv.withKey("k2");
        assertEquals("k2", kv2.key());
        assertEquals(123, kv2.value());
        // original unchanged (immutability by construction)
        assertEquals("k", kv.key());
        assertEquals(123, kv.value());
    }

    @Test
    void testWithValue() {
        var kv = KeyValue.of("k", 123);
        var kv2 = kv.withValue(456);
        assertEquals("k", kv2.key());
        assertEquals(456, kv2.value());
        // original unchanged
        assertEquals("k", kv.key());
        assertEquals(123, kv.value());
    }
}
