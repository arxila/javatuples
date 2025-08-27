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

class QuartetTest {

    @Test
    void testOfAndAccess() {
        var q = Quartet.of("a", 1, true, 2.0);
        assertEquals(4, q.size());
        assertEquals(List.of("a", 1, true, 2.0), q.values());
        assertEquals("a", q.value0());
        assertEquals(1, q.value1());
        assertEquals(true, q.value2());
        assertEquals(2.0, q.value3());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Quartet.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Quartet.of(new Object[]{"a", 1, true}));
        assertThrows(IllegalArgumentException.class, () -> Quartet.of(new Object[]{"a", 1, true, 2.0, "x"}));

        assertThrows(NullPointerException.class, () -> Quartet.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Quartet.of(List.of("a", 1, true)));
        assertThrows(IllegalArgumentException.class, () -> Quartet.of(List.of("a", 1, true, 2.0, "x")));
    }

    @Test
    void testContains() {
        var q = Quartet.of("a", 1, true, 2.0);
        assertTrue(q.contains(true));
        assertFalse(q.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var q = Quartet.of("a", 1, true, 2.0);

        assertEquals(List.of("x", 1, true, 2.0), q.withValue0("x").values());
        assertEquals(List.of("a", "y", true, 2.0), q.withValue1("y").values());
        assertEquals(List.of("a", 1, "z", 2.0), q.withValue2("z").values());
        assertEquals(List.of("a", 1, true, "w"), q.withValue3("w").values());

        var grown = q.withValue4(9L);
        assertEquals(5, grown.size());
        assertEquals(List.of("a", 1, true, 2.0, 9L), grown.values());

        assertEquals(List.of(1, true, 2.0), q.withoutValue0().values());
        assertEquals(List.of("a", true, 2.0), q.withoutValue1().values());
        assertEquals(List.of("a", 1, 2.0), q.withoutValue2().values());
        assertEquals(List.of("a", 1, true), q.withoutValue3().values());
    }

    @Test
    void testValueOutOfBounds() {
        var q = Quartet.of("a", 1, true, 2.0);
        assertThrows(IndexOutOfBoundsException.class, () -> q.value(4));
        assertThrows(IndexOutOfBoundsException.class, () -> q.value(-1));
    }
}
