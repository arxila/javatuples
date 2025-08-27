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

class AllTuplesIndexedValueAccessTest {

    // Empty / Tuple0: only invalid indices

    @Test
    void empty_invalidIndices() {
        var t = Empty.of();
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(0));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple0_invalidIndices() {
        var t = Tuple0.of();
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(0));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Solo / Tuple1

    @Test
    void solo_validAndInvalidIndices() {
        var t = Solo.of("a0");
        assertEquals("a0", t.value(0));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(1));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple1_validAndInvalidIndices() {
        var t = Tuple1.of("a0");
        assertEquals("a0", t.value(0));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(1));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Pair / Tuple2

    @Test
    void pair_validAndInvalidIndices() {
        var t = Pair.of("a0", "a1");
        assertEquals("a0", t.value(0));
        assertEquals("a1", t.value(1));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(2));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple2_validAndInvalidIndices() {
        var t = Tuple2.of("a0", "a1");
        assertEquals("a0", t.value(0));
        assertEquals("a1", t.value(1));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(2));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Trio / Tuple3

    @Test
    void trio_validAndInvalidIndices() {
        var t = Trio.of("a0", "a1", "a2");
        assertEquals("a0", t.value(0));
        assertEquals("a1", t.value(1));
        assertEquals("a2", t.value(2));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(3));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple3_validAndInvalidIndices() {
        var t = Tuple3.of("a0", "a1", "a2");
        assertEquals("a0", t.value(0));
        assertEquals("a1", t.value(1));
        assertEquals("a2", t.value(2));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(3));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Quartet / Tuple4

    @Test
    void quartet_validAndInvalidIndices() {
        var t = Quartet.of("a0", "a1", "a2", "a3");
        assertEquals("a0", t.value(0));
        assertEquals("a1", t.value(1));
        assertEquals("a2", t.value(2));
        assertEquals("a3", t.value(3));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(4));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple4_validAndInvalidIndices() {
        var t = Tuple4.of("a0", "a1", "a2", "a3");
        assertEquals("a0", t.value(0));
        assertEquals("a1", t.value(1));
        assertEquals("a2", t.value(2));
        assertEquals("a3", t.value(3));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(4));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Quintet / Tuple5

    @Test
    void quintet_validAndInvalidIndices() {
        var t = Quintet.of("a0", "a1", "a2", "a3", "a4");
        for (int i = 0; i < 5; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(5));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple5_validAndInvalidIndices() {
        var t = Tuple5.of("a0", "a1", "a2", "a3", "a4");
        for (int i = 0; i < 5; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(5));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Sextet / Tuple6

    @Test
    void sextet_validAndInvalidIndices() {
        var t = Sextet.of("a0", "a1", "a2", "a3", "a4", "a5");
        for (int i = 0; i < 6; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(6));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple6_validAndInvalidIndices() {
        var t = Tuple6.of("a0", "a1", "a2", "a3", "a4", "a5");
        for (int i = 0; i < 6; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(6));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Septet / Tuple7

    @Test
    void septet_validAndInvalidIndices() {
        var t = Septet.of("a0", "a1", "a2", "a3", "a4", "a5", "a6");
        for (int i = 0; i < 7; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(7));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple7_validAndInvalidIndices() {
        var t = Tuple7.of("a0", "a1", "a2", "a3", "a4", "a5", "a6");
        for (int i = 0; i < 7; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(7));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Octet / Tuple8

    @Test
    void octet_validAndInvalidIndices() {
        var t = Octet.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7");
        for (int i = 0; i < 8; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(8));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple8_validAndInvalidIndices() {
        var t = Tuple8.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7");
        for (int i = 0; i < 8; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(8));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Nonet / Tuple9

    @Test
    void nonet_validAndInvalidIndices() {
        var t = Nonet.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8");
        for (int i = 0; i < 9; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(9));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple9_validAndInvalidIndices() {
        var t = Tuple9.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8");
        for (int i = 0; i < 9; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(9));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    // Decet / Tuple10

    @Test
    void decet_validAndInvalidIndices() {
        var t = Decet.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9");
        for (int i = 0; i < 10; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(10));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }

    @Test
    void tuple10_validAndInvalidIndices() {
        var t = Tuple10.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9");
        for (int i = 0; i < 10; i++) {
            assertEquals("a" + i, t.value(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(10));
        assertThrows(IndexOutOfBoundsException.class, () -> t.value(-1));
    }
}
