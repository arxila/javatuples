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

class QuintetTest {

    @Test
    void testOfAndAccess() {
        var t = Quintet.of("a", 1, true, 2.0, 9L);
        assertEquals(5, t.size());
        assertEquals(List.of("a", 1, true, 2.0, 9L), t.values());
        assertEquals("a", t.value0());
        assertEquals(1, t.value1());
        assertEquals(true, t.value2());
        assertEquals(2.0, t.value3());
        assertEquals(9L, t.value4());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Quintet.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Quintet.of(new Object[]{"a", 1, true, 2.0}));
        assertThrows(IllegalArgumentException.class, () -> Quintet.of(new Object[]{"a", 1, true, 2.0, 9L, "x"}));

        assertThrows(NullPointerException.class, () -> Quintet.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Quintet.of(List.of("a", 1, true, 2.0)));
        assertThrows(IllegalArgumentException.class, () -> Quintet.of(List.of("a", 1, true, 2.0, 9L, "x")));
    }

    @Test
    void testContains() {
        var t = Quintet.of("a", 1, true, 2.0, 9L);
        assertTrue(t.contains(9L));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Quintet.of("a", 1, true, 2.0, 9L);

        assertEquals(List.of("x", 1, true, 2.0, 9L), t.withValue0("x").values());
        assertEquals(List.of("a", "y", true, 2.0, 9L), t.withValue1("y").values());
        assertEquals(List.of("a", 1, "z", 2.0, 9L), t.withValue2("z").values());
        assertEquals(List.of("a", 1, true, "w", 9L), t.withValue3("w").values());
        assertEquals(List.of("a", 1, true, 2.0, "k"), t.withValue4("k").values());

        var grown = t.withValue5("G");
        assertEquals(6, grown.size());

        assertEquals(List.of(1, true, 2.0, 9L), t.withoutValue0().values());
        assertEquals(List.of("a", true, 2.0, 9L), t.withoutValue1().values());
        assertEquals(List.of("a", 1, 2.0, 9L), t.withoutValue2().values());
        assertEquals(List.of("a", 1, true, 9L), t.withoutValue3().values());
        assertEquals(List.of("a", 1, true, 2.0), t.withoutValue4().values());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Quintet.of("a", 1, true, 2.0, 9L);
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(5));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
