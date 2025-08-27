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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Tuple1Test {

    @Test
    void testOfAndAccess() {
        var t = Tuple1.of("a");
        assertEquals(1, t.size());
        assertEquals("a", t.value0());
        assertEquals("a", t.value(0));
        assertEquals(List.of("a"), t.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Tuple1.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Tuple1.of(new Object[]{}));
        assertThrows(IllegalArgumentException.class, () -> Tuple1.of(new Object[]{"a", "b"}));

        assertThrows(NullPointerException.class, () -> Tuple1.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Tuple1.of(List.of()));
        assertThrows(IllegalArgumentException.class, () -> Tuple1.of(List.of("a", "b")));
    }

    @Test
    void testContains() {
        var t = Tuple1.of("a");
        assertTrue(t.contains("a"));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Tuple1.of("a");
        assertEquals(List.of("x"), t.withValue0("x").values());

        var grown = t.withValue1(42);
        assertEquals(2, grown.size());
        assertEquals(List.of("a", 42), grown.values());

        var empty = t.withoutValue0();
        assertEquals(0, empty.size());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Tuple1.of("a");
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(1));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
