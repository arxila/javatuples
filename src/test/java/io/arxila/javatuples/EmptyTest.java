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

class EmptyTest {

    @Test
    void testOfAndAccess() {
        var empty = Empty.of();
        assertEquals(0, empty.size());
        assertEquals(List.of(), empty.values());
        assertFalse(empty.contains("anything"));
    }

    @Test
    void testValueOutOfBounds() {
        var empty = Empty.of();
        assertThrows(IndexOutOfBoundsException.class, () -> empty.value(0));
        assertThrows(IndexOutOfBoundsException.class, () -> empty.value(-1));
    }

    @Test
    void testGrow() {
        var solo = Empty.of().withValue0("x");
        assertEquals(1, solo.size());
        assertEquals("x", solo.value0());
    }
}
