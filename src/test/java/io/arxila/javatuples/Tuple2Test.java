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

class Tuple2Test {

    @Test
    void testOfAndAccess() {
        var t = Tuple2.of("a", 1);
        assertEquals(2, t.size());
        assertEquals("a", t.value0());
        assertEquals(1, t.value1());
        assertEquals(List.of("a", 1), t.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Tuple2.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Tuple2.of(new Object[]{"a"}));
        assertThrows(IllegalArgumentException.class, () -> Tuple2.of(new Object[]{"a", 1, "x"}));

        assertThrows(NullPointerException.class, () -> Tuple2.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Tuple2.of(List.of("a")));
        assertThrows(IllegalArgumentException.class, () -> Tuple2.of(List.of("a", 1, "x")));
    }

    @Test
    void testContains() {
        var t = Tuple2.of("a", 1);
        assertTrue(t.contains(1));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Tuple2.of("a", 1);
        assertEquals(List.of("x", 1), t.withValue0("x").values());
        assertEquals(List.of("a", "y"), t.withValue1("y").values());

        var grown = t.withValue2(true);
        assertEquals(3, grown.size());

        assertEquals(1, t.withoutValue0().size());
        assertEquals(1, t.withoutValue1().size());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Tuple2.of("a", 1);
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(2));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
