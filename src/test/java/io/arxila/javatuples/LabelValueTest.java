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
import static org.junit.jupiter.api.Assertions.assertThrows;

class LabelValueTest {

    @Test
    void testOfAndAccess() {
        var lv = LabelValue.of("label", 3.14);
        assertEquals("label", lv.label());
        assertEquals(3.14, lv.value());
    }

    @Test
    void testOfArrayValidation() {
        assertThrows(NullPointerException.class, () -> LabelValue.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> LabelValue.of(new Object[]{}));
        assertThrows(IllegalArgumentException.class, () -> LabelValue.of(new Object[]{"l", 1, "extra"}));
    }

    @Test
    void testOfListValidation() {
        assertThrows(NullPointerException.class, () -> LabelValue.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> LabelValue.of(List.of()));
        assertThrows(IllegalArgumentException.class, () -> LabelValue.of(List.of("l", 1, "extra")));
    }

    @Test
    void testWithLabel() {
        var lv = LabelValue.of("label", 3.14);
        var lv2 = lv.withLabel("label2");
        assertEquals("label2", lv2.label());
        assertEquals(3.14, lv2.value());
        // original unchanged
        assertEquals("label", lv.label());
        assertEquals(3.14, lv.value());
    }

    @Test
    void testWithValue() {
        var lv = LabelValue.of("label", 3.14);
        var lv2 = lv.withValue(2.71);
        assertEquals("label", lv2.label());
        assertEquals(2.71, lv2.value());
        // original unchanged
        assertEquals("label", lv.label());
        assertEquals(3.14, lv.value());
    }
}
