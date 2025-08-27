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

class SextetTest {

    @Test
    void testOfAndAccess() {
        var t = Sextet.of("a", 1, true, 2.0, 9L, 'c');
        assertEquals(6, t.size());
        assertEquals(List.of("a", 1, true, 2.0, 9L, 'c'), t.values());
        assertEquals('c', t.value5());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Sextet.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Sextet.of(new Object[]{"a", 1, true, 2.0, 9L}));
        assertThrows(IllegalArgumentException.class, () -> Sextet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c', "x"}));

        assertThrows(NullPointerException.class, () -> Sextet.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Sextet.of(List.of("a", 1, true, 2.0, 9L)));
        assertThrows(IllegalArgumentException.class, () -> Sextet.of(List.of("a", 1, true, 2.0, 9L, 'c', "x")));
    }

    @Test
    void testContains() {
        var t = Sextet.of("a", 1, true, 2.0, 9L, 'c');
        assertTrue(t.contains('c'));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Sextet.of("a", 1, true, 2.0, 9L, 'c');

        assertEquals(List.of("x", 1, true, 2.0, 9L, 'c'), t.withValue0("x").values());
        assertEquals(List.of("a", "y", true, 2.0, 9L, 'c'), t.withValue1("y").values());
        assertEquals(List.of("a", 1, "z", 2.0, 9L, 'c'), t.withValue2("z").values());
        assertEquals(List.of("a", 1, true, "w", 9L, 'c'), t.withValue3("w").values());
        assertEquals(List.of("a", 1, true, 2.0, "k", 'c'), t.withValue4("k").values());
        assertEquals(List.of("a", 1, true, 2.0, 9L, "q"), t.withValue5("q").values());

        var grown = t.withValue6("G");
        assertEquals(7, grown.size());

        assertEquals(List.of(1, true, 2.0, 9L, 'c'), t.withoutValue0().values());
        assertEquals(List.of("a", true, 2.0, 9L, 'c'), t.withoutValue1().values());
        assertEquals(List.of("a", 1, 2.0, 9L, 'c'), t.withoutValue2().values());
        assertEquals(List.of("a", 1, true, 9L, 'c'), t.withoutValue3().values());
        assertEquals(List.of("a", 1, true, 2.0, 'c'), t.withoutValue4().values());
        assertEquals(List.of("a", 1, true, 2.0, 9L), t.withoutValue5().values());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Sextet.of("a", 1, true, 2.0, 9L, 'c');
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(6));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
