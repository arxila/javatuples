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

class AllTuplesValueAccessTest {

    // Named tuples

    @Test
    void solo_value0() {
        var t = Solo.of(0);
        assertEquals(0, t.value0());
    }

    @Test
    void pair_value0_value1() {
        var t = Pair.of(0, 1);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
    }

    @Test
    void trio_value0_value1_value2() {
        var t = Trio.of(0, 1, 2);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
    }

    @Test
    void quartet_value0_value1_value2_value3() {
        var t = Quartet.of(0, 1, 2, 3);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
    }

    @Test
    void quintet_value0_value1_value2_value3_value4() {
        var t = Quintet.of(0, 1, 2, 3, 4);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
    }

    @Test
    void sextet_value0_to_value5() {
        var t = Sextet.of(0, 1, 2, 3, 4, 5);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
    }

    @Test
    void septet_value0_to_value6() {
        var t = Septet.of(0, 1, 2, 3, 4, 5, 6);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
    }

    @Test
    void octet_value0_to_value7() {
        var t = Octet.of(0, 1, 2, 3, 4, 5, 6, 7);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
        assertEquals(7, t.value7());
    }

    @Test
    void nonet_value0_to_value8() {
        var t = Nonet.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
        assertEquals(7, t.value7());
        assertEquals(8, t.value8());
    }

    @Test
    void decet_value0_to_value9() {
        var t = Decet.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
        assertEquals(7, t.value7());
        assertEquals(8, t.value8());
        assertEquals(9, t.value9());
    }

    // Numbered tuples

    @Test
    void tuple1_value0() {
        var t = Tuple1.of(0);
        assertEquals(0, t.value0());
    }

    @Test
    void tuple2_value0_value1() {
        var t = Tuple2.of(0, 1);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
    }

    @Test
    void tuple3_value0_to_value2() {
        var t = Tuple3.of(0, 1, 2);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
    }

    @Test
    void tuple4_value0_to_value3() {
        var t = Tuple4.of(0, 1, 2, 3);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
    }

    @Test
    void tuple5_value0_to_value4() {
        var t = Tuple5.of(0, 1, 2, 3, 4);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
    }

    @Test
    void tuple6_value0_to_value5() {
        var t = Tuple6.of(0, 1, 2, 3, 4, 5);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
    }

    @Test
    void tuple7_value0_to_value6() {
        var t = Tuple7.of(0, 1, 2, 3, 4, 5, 6);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
    }

    @Test
    void tuple8_value0_to_value7() {
        var t = Tuple8.of(0, 1, 2, 3, 4, 5, 6, 7);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
        assertEquals(7, t.value7());
    }

    @Test
    void tuple9_value0_to_value8() {
        var t = Tuple9.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
        assertEquals(7, t.value7());
        assertEquals(8, t.value8());
    }

    @Test
    void tuple10_value0_to_value9() {
        var t = Tuple10.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(0, t.value0());
        assertEquals(1, t.value1());
        assertEquals(2, t.value2());
        assertEquals(3, t.value3());
        assertEquals(4, t.value4());
        assertEquals(5, t.value5());
        assertEquals(6, t.value6());
        assertEquals(7, t.value7());
        assertEquals(8, t.value8());
        assertEquals(9, t.value9());
    }
}
