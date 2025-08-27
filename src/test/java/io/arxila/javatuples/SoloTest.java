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

class SoloTest {

    @Test
    void testOfAndAccess() {
        var solo = Solo.of("a");
        assertEquals(1, solo.size());
        assertEquals("a", solo.value0());
        assertEquals("a", solo.value(0));
        assertEquals(List.of("a"), solo.values());
    }

    @Test
    void testOfArrayAndListValidation() {
        assertThrows(NullPointerException.class, () -> Solo.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> Solo.of(new Object[]{}));
        assertThrows(IllegalArgumentException.class, () -> Solo.of(new Object[]{"a", "b"}));

        assertThrows(NullPointerException.class, () -> Solo.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> Solo.of(List.of()));
        assertThrows(IllegalArgumentException.class, () -> Solo.of(List.of("a", "b")));
    }

    @Test
    void testContains() {
        var solo = Solo.of("a");
        assertTrue(solo.contains("a"));
        assertFalse(solo.contains("b"));
    }

    @Test
    void testWithersGrowShrink() {
        var solo = Solo.of("a");
        var replaced = solo.withValue0("x");
        assertEquals(List.of("x"), replaced.values());

        var grown = solo.withValue1(42);
        assertEquals(2, grown.size());
        assertEquals("a", grown.value0());
        assertEquals(42, grown.value1());

        var empty = solo.withoutValue0();
        assertEquals(0, empty.size());
    }

    @Test
    void testValueOutOfBounds() {
        var solo = Solo.of("a");
        assertThrows(IndexOutOfBoundsException.class, () -> solo.value(1));
        assertThrows(IndexOutOfBoundsException.class, () -> solo.value(-1));
    }
}
