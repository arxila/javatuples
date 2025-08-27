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

class PairTest {

    @Test
    void testOfAndAccess() {
        var pair = Pair.of("a", 1);
        assertEquals(2, pair.size());
        assertEquals("a", pair.value0());
        assertEquals(1, pair.value1());
        assertEquals("a", pair.value(0));
        assertEquals(1, pair.value(1));
        assertEquals(List.of("a", 1), pair.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Pair.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Pair.of(new Object[]{"a"}));
        assertThrows(IllegalArgumentException.class, () -> Pair.of(new Object[]{"a", 1, 2}));

        assertThrows(NullPointerException.class, () -> Pair.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Pair.of(List.of("a")));
        assertThrows(IllegalArgumentException.class, () -> Pair.of(List.of("a", 1, 2)));
    }

    @Test
    void testContains() {
        var pair = Pair.of("a", 1);
        assertTrue(pair.contains("a"));
        assertTrue(pair.contains(1));
        assertFalse(pair.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var pair = Pair.of("a", 1);
        var replaced0 = pair.withValue0("x");
        assertEquals(List.of("x", 1), replaced0.values());

        var replaced1 = pair.withValue1("y");
        assertEquals(List.of("a", "y"), replaced1.values());

        var grown = pair.withValue2(true);
        assertEquals(3, grown.size());
        assertEquals(List.of("a", 1, true), grown.values());

        var without0 = pair.withoutValue0();
        assertEquals(1, without0.size());
        assertEquals(1, without0.value0());

        var without1 = pair.withoutValue1();
        assertEquals(1, without1.size());
        assertEquals("a", without1.value0());
    }

    @Test
    void testValueOutOfBounds() {
        var pair = Pair.of("a", 1);
        assertThrows(IndexOutOfBoundsException.class, () -> pair.value(2));
        assertThrows(IndexOutOfBoundsException.class, () -> pair.value(-1));
    }
}
