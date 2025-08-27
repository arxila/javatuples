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

class NonetTest {

    @Test
    void testOfAndAccess() {
        var t = Nonet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine");
        assertEquals(9, t.size());
        assertEquals(List.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine"), t.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Nonet.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Nonet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c', "z", 8}));
        assertThrows(IllegalArgumentException.class, () -> Nonet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", "x"}));

        assertThrows(NullPointerException.class, () -> Nonet.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Nonet.of(List.of("a", 1, true, 2.0, 9L, 'c', "z", 8)));
        assertThrows(IllegalArgumentException.class, () -> Nonet.of(List.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", "x")));
    }

    @Test
    void testContains() {
        var t = Nonet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine");
        assertTrue(t.contains("nine"));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Nonet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine");

        assertEquals(10, t.withValue9("G").size());
        assertEquals(8, t.withoutValue8().size());
        assertEquals(List.of("x", 1, true, 2.0, 9L, 'c', "z", 8, "nine"), t.withValue0("x").values());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Nonet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine");
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(9));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
