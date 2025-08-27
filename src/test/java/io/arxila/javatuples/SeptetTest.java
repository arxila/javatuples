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

class SeptetTest {

    @Test
    void testOfAndAccess() {
        var t = Septet.of("a", 1, true, 2.0, 9L, 'c', "z");
        assertEquals(7, t.size());
        assertEquals(List.of("a", 1, true, 2.0, 9L, 'c', "z"), t.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Septet.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Septet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c'}));
        assertThrows(IllegalArgumentException.class, () -> Septet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c', "z", "x"}));

        assertThrows(NullPointerException.class, () -> Septet.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Septet.of(List.of("a", 1, true, 2.0, 9L, 'c')));
        assertThrows(IllegalArgumentException.class, () -> Septet.of(List.of("a", 1, true, 2.0, 9L, 'c', "z", "x")));
    }

    @Test
    void testContains() {
        var t = Septet.of("a", 1, true, 2.0, 9L, 'c', "z");
        assertTrue(t.contains("z"));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Septet.of("a", 1, true, 2.0, 9L, 'c', "z");

        assertEquals(8, t.withValue7("G").size());
        assertEquals(6, t.withoutValue6().size());
        assertEquals("a", t.withoutValue1().value0());
        assertEquals(List.of("x", 1, true, 2.0, 9L, 'c', "z"), t.withValue0("x").values());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Septet.of("a", 1, true, 2.0, 9L, 'c', "z");
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(7));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
