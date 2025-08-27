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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Tuple4Test {

    @Test
    void testOfAndAccess() {
        var t = Tuple4.of("a", 1, true, 2.0);
        assertEquals(4, t.size());
        assertEquals("a", t.value0());
        assertEquals(1, t.value1());
        assertEquals(true, t.value2());
        assertEquals(2.0, t.value3());
    }

    @Test
    void testContainsAndBounds() {
        var t = Tuple4.of("a", 1, true, 2.0);
        assertTrue(t.contains(2.0));
        assertFalse(t.contains("b"));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(4));
    }

    @Test
    void testWithersGrowShrink() {
        var t = Tuple4.of("a", 1, true, 2.0);
        assertEquals(5, t.withValue4("G").size());
        assertEquals(3, t.withoutValue3().size());
        assertEquals("x", t.withValue0("x").value0());
    }
}
