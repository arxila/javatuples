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

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MapEntryTest {

    @Test
    void testOfAndAccessors() {
        var me = MapEntry.of("k", 42);
        assertEquals("k", me.key());
        assertEquals(42, me.value());
        // Map.Entry API
        assertEquals("k", me.getKey());
        assertEquals(42, me.getValue());
    }

    @Test
    void testOfArrayValidation() {
        assertThrows(NullPointerException.class, () -> MapEntry.of((Object[]) null));
        assertThrows(IllegalArgumentException.class, () -> MapEntry.of(new Object[]{}));
        assertThrows(IllegalArgumentException.class, () -> MapEntry.of(new Object[]{"k", 1, "extra"}));
    }

    @Test
    void testOfListValidation() {
        assertThrows(NullPointerException.class, () -> MapEntry.of((List<Object>) null));
        assertThrows(IllegalArgumentException.class, () -> MapEntry.of(List.of()));
        assertThrows(IllegalArgumentException.class, () -> MapEntry.of(List.of("k", 1, "extra")));
    }

    @Test
    void testWithKey() {
        var me = MapEntry.of("k", 42);
        var me2 = me.withKey("k2");
        assertEquals("k2", me2.key());
        assertEquals(42, me2.value());
        // original unchanged
        assertEquals("k", me.key());
        assertEquals(42, me.value());
    }

    @Test
    void testWithValue() {
        var me = MapEntry.of("k", 42);
        var me2 = me.withValue(43);
        assertEquals("k", me2.key());
        assertEquals(43, me2.value());
        // original unchanged
        assertEquals("k", me.key());
        assertEquals(42, me.value());
    }

    @Test
    void testSetValueUnsupported() {
        var me = MapEntry.of("k", 42);
        assertThrows(UnsupportedOperationException.class, () -> me.setValue(99));
        // still unchanged
        assertEquals("k", me.key());
        assertEquals(42, me.value());
    }

    @Test
    void testEqualsAndHashCodeAgainstMapEntryContract() {
        var me = MapEntry.of("k", 42);
        Map.Entry<String, Integer> simple = new AbstractMap.SimpleEntry<>("k", 42);

        // equals must apply to any Map.Entry implementation
        assertEquals(me, simple);
        assertEquals(simple, me);

        // hashCode should be consistent with Map.Entry contract
        assertEquals(simple.hashCode(), me.hashCode());
    }

    @Test
    void testEqualsWithNullsAndDifferentValues() {
        var meNulls = MapEntry.of(null, null);
        Map.Entry<String, Integer> simpleNulls = new AbstractMap.SimpleEntry<>(null, null);

        assertEquals(meNulls, simpleNulls);
        assertEquals(simpleNulls, meNulls);
        assertEquals(simpleNulls.hashCode(), meNulls.hashCode());

        var me1 = MapEntry.of("k", 1);
        var me2 = MapEntry.of("k", 2);
        var me3 = MapEntry.of("k2", 1);

        assertNotEquals(me1, me2);
        assertNotEquals(me1, me3);
        assertNotEquals(me2, me3);
    }
}
