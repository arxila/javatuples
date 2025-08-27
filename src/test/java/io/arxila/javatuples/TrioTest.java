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

class TrioTest {

    @Test
    void testOfAndAccess() {
        var trio = Trio.of("a", 1, true);
        assertEquals(3, trio.size());
        assertEquals("a", trio.value0());
        assertEquals(1, trio.value1());
        assertEquals(true, trio.value2());
        assertEquals(List.of("a", 1, true), trio.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Trio.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Trio.of(new Object[]{"a", 1}));
        assertThrows(IllegalArgumentException.class, () -> Trio.of(new Object[]{"a", 1, true, "extra"}));

        assertThrows(NullPointerException.class, () -> Trio.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Trio.of(List.of("a", 1)));
        assertThrows(IllegalArgumentException.class, () -> Trio.of(List.of("a", 1, true, "extra")));
    }

    @Test
    void testContains() {
        var trio = Trio.of("a", 1, true);
        assertTrue(trio.contains("a"));
        assertTrue(trio.contains(1));
        assertTrue(trio.contains(true));
        assertFalse(trio.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var trio = Trio.of("a", 1, true);

        assertEquals(List.of("x", 1, true), trio.withValue0("x").values());
        assertEquals(List.of("a", "y", true), trio.withValue1("y").values());
        assertEquals(List.of("a", 1, "z"), trio.withValue2("z").values());

        var grown = trio.withValue3(3.14);
        assertEquals(4, grown.size());
        assertEquals(List.of("a", 1, true, 3.14), grown.values());

        assertEquals(List.of(1, true), trio.withoutValue0().values());
        assertEquals(List.of("a", true), trio.withoutValue1().values());
        assertEquals(List.of("a", 1), trio.withoutValue2().values());
    }

    @Test
    void testValueOutOfBounds() {
        var trio = Trio.of("a", 1, true);
        assertThrows(IndexOutOfBoundsException.class, () -> trio.value(3));
        assertThrows(IndexOutOfBoundsException.class, () -> trio.value(-1));
    }
}
