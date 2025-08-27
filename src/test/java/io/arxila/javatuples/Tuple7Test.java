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
import static org.junit.jupiter.api.Assertions.assertThrows;

class Tuple7Test {

    @Test
    void testOfAndAccess() {
        var t = Tuple7.of("a", 1, true, 2.0, 9L, 'c', "z");
        assertEquals(7, t.size());
        assertEquals("z", t.value6());
    }

    @Test
    void testWithersGrowShrink() {
        var t = Tuple7.of("a", 1, true, 2.0, 9L, 'c', "z");
        assertEquals(8, t.withValue7("G").size());
        assertEquals(6, t.withoutValue6().size());
        assertEquals("x", t.withValue0("x").value0());
    }

    @Test
    void testBounds() {
        var t = Tuple7.of("a", 1, true, 2.0, 9L, 'c', "z");
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(7));
    }
}
