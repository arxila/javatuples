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

class Tuple10Test {

    @Test
    void testOfAndAccess() {
        var t = Tuple10.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);
        assertEquals(10, t.size());
        assertEquals(10, t.value9());
    }

    @Test
    void testWithersShrink() {
        var t = Tuple10.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);
        // No growth beyond 10; test replacements and shrink
        assertEquals("x", t.withValue0("x").value0());
        assertEquals("y", t.withValue9("y").value9());
        assertEquals(9, t.withoutValue0().size());
        assertEquals(9, t.withoutValue9().size());
    }

    @Test
    void testBounds() {
        var t = Tuple10.of("a", 1, true, 2.0, 9L, 'c', "z", 8, "nine", 10);
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(10));
    }
}
