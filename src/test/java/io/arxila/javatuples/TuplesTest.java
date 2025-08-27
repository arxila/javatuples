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

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TuplesTest {

    @Test
    void testContainsAll_Collection() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertTrue(pair.containsAll(List.of("test", 1)));
        assertFalse(pair.containsAll(List.of("test", 2)));
    }

    @Test
    void testContainsAll_Tuple() {
        Pair<String, Integer> pair1 = new Pair<>("test", 1);
        Pair<String, Integer> pair2 = new Pair<>("test", 1);
        assertTrue(pair1.containsAll(pair2));
    }

    @Test
    void testContainsAll_VarArgs() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertTrue(pair.containsAll("test", 1));
        assertFalse(pair.containsAll("test", 2));
    }

    @Test
    void testContainsAny_Collection() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertTrue(pair.containsAny(List.of("test", 2)));
        assertFalse(pair.containsAny(List.of("none", 2)));
    }

    @Test
    void testContainsAny_Tuple() {
        Pair<String, Integer> pair1 = new Pair<>("test", 1);
        Pair<String, Integer> pair2 = new Pair<>("test", 2);
        assertTrue(pair1.containsAny(pair2));
    }

    @Test
    void testContainsAny_VarArgs() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertTrue(pair.containsAny("test", 2));
        assertFalse(pair.containsAny("none", 2));
    }

    @Test
    void testIndexOf() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertEquals(0, pair.indexOf("test"));
        assertEquals(1, pair.indexOf(1));
        assertEquals(-1, pair.indexOf("nonexistent"));
    }

    @Test
    void testLastIndexOf() {
        Pair<String, String> pair = new Pair<>("test", "test");
        assertEquals(1, pair.lastIndexOf("test"));
        assertEquals(-1, pair.lastIndexOf("nonexistent"));
    }

    @Test
    void testToList() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertEquals(List.of("test", 1), pair.toList());
    }

    @Test
    void testToArray() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertArrayEquals(new Object[]{"test", 1}, pair.toArray());
    }

    @Test
    void testToTypedArray() {
        Pair<String, String> pair = new Pair<>("test1", "test2");
        String[] array = pair.toArray(new String[2]);
        assertArrayEquals(new String[]{"test1", "test2"}, array);
    }

    @Test
    void testIterator() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        Iterator<Object> iterator = pair.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("test", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEqualsIgnoreOrder_SameInstance() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertTrue(pair.equalsIgnoreOrder(pair));
    }

    @Test
    void testEqualsIgnoreOrder_NullOther() {
        Pair<String, Integer> pair = new Pair<>("test", 1);
        assertFalse(pair.equalsIgnoreOrder(null));
    }

    @Test
    void testEqualsIgnoreOrder_DifferentOrder() {
        Pair<String, Integer> pair1 = new Pair<>("test", 1);
        Pair<Integer, String> pair2 = new Pair<>(1, "test");
        assertTrue(pair1.equalsIgnoreOrder(pair2));
    }

    @Test
    void testEqualsIgnoreOrder_DifferentElements() {
        Pair<String, Integer> pair1 = new Pair<>("test", 1);
        Pair<String, Integer> pair2 = new Pair<>("test", 2);
        assertFalse(pair1.equalsIgnoreOrder(pair2));
    }
}
