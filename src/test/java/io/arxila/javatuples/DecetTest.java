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

class DecetTest {

    @Test
    void testOfAndAccess() {
        var t = Decet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);
        assertEquals(10, t.size());
        assertEquals(List.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10), t.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Decet.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Decet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c', "z", 8, "nine"}));
        assertThrows(IllegalArgumentException.class, () -> Decet.of(new Object[]{"a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10, "x"}));

        assertThrows(NullPointerException.class, () -> Decet.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Decet.of(List.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine")));
        assertThrows(IllegalArgumentException.class, () -> Decet.of(List.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10, "x")));
    }

    @Test
    void testContains() {
        var t = Decet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);
        assertTrue(t.contains(10));
        assertFalse(t.contains("b"));
    }

    @Test
    void testWithersShrink() {
        var t = Decet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);

        // Replace a few positions
        assertEquals("x", t.withValue0("x").value0());
        assertEquals("y", t.withValue9("y").value9());

        // Shrink (no growth beyond Decet)
        assertEquals(9, t.withoutValue9().size());
        assertEquals(9, t.withoutValue0().size());
    }

    @Test
    void testValueOutOfBounds() {
        var t = Decet.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(10));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
