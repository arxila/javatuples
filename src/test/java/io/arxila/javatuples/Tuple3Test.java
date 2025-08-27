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

class Tuple3Test {

    @Test
    void testOfAndAccess() {
        var t = Tuple3.of("a", 1, true);
        assertEquals(3, t.size());
        assertEquals(List.of("a", 1, true), t.values());
        assertEquals("a", t.value0());
        assertEquals(1, t.value1());
        assertEquals(true, t.value2());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Tuple3.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Tuple3.of(new Object[]{"a", 1}));
        assertThrows(IllegalArgumentException.class, () -> Tuple3.of(new Object[]{"a", 1, true, "x"}));

        assertThrows(NullPointerException.class, () -> Tuple3.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Tuple3.of(List.of("a", 1)));
        assertThrows(IllegalArgumentException.class, () -> Tuple3.of(List.of("a", 1, true, "x")));
    }

    @Test
    void testContains() {
        var t = Tuple3.of("a", 1, true);
        assertTrue(t.contains(true));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Tuple3.of("a", 1, true);

        assertEquals(List.of("x", 1, true), t.withValue0("x").values());
        assertEquals(List.of("a", "y", true), t.withValue1("y").values());
        assertEquals(List.of("a", 1, "z"), t.withValue2("z").values());

        var grown = t.withValue3(3.14);
        assertEquals(4, grown.size());

        assertEquals(2, t.withoutValue0().size());
        assertEquals(2, t.withoutValue1().size());
        assertEquals(2, t.withoutValue2().size());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Tuple3.of("a", 1, true);
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(3));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
