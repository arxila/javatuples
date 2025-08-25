/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The JAVATUPLES team (http://www.javatuples.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package io.arxila.javatuples;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    
    @Test
    public void testMain() throws Exception {
        
        
        final Decet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> decade =
            Decet.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10));

        List<Integer> decadeList = new ArrayList<Integer>();
        
        for (final Object value : decade) {
            decadeList.add((Integer)value);
            System.out.println(value);
        }
        
        final Decet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> decade2 = 
            Decet.of(decadeList); 
            
        assertEquals(decade, decade2);
        
        final Decet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> decade3 = 
            Decet.of(decadeList);
        
        assertEquals(decade, decade3);
        
        final Nonet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> ennead =
            Nonet.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9));

        final Sextet<String,Integer,String,String,String,String> sextet =
            Sextet.of("1.0",Integer.valueOf(2),"3.0","4.0","5.0","6.0");
        
        Pair<String,Object> pair = Pair.of("a", null);
        
        final Object o = null;
        assertTrue(pair.contains("a"));
        assertTrue(pair.contains(null));
        assertTrue(pair.containsAll(o));
        assertTrue(pair.containsAll(null,"a"));
        assertFalse(pair.containsAll(null, "b"));
        
        final byte[] serSextet = SerializationUtils.serialize(sextet);
        System.out.println(Arrays.asList(ArrayUtils.toObject(serSextet)));
        final Sextet<String,Integer,String,String,String,String> sextetUnSer =
            (Sextet<String,Integer,String,String,String,String>) SerializationUtils.deserialize(serSextet);
        System.out.println(sextetUnSer);
        
        
        
        String str = null;
        Integer integ = null;
        Double[] doubleArray = null;
        
        Trio<String,Integer,Double[]> triplet = Trio.of(str, integ, doubleArray);
        
        System.out.println(triplet);

        
        Pair<String,Integer> pair1 = Pair.of("hello", Integer.valueOf(23));
        Quintet<String,Integer,Double,String,String> quintet = 
            Quintet.of("a", Integer.valueOf(3), Double.valueOf(34.2), "b", "c"); 

        Pair<String,Integer> pair2 = new Pair<String,Integer>("hello", Integer.valueOf(23));
        Quintet<String,Integer,Double,String,String> quintet2 = 
            new Quintet<String,Integer,Double,String,String>("a", Integer.valueOf(3), Double.valueOf(34.2), "b", "c"); 

        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(quintet);
        System.out.println(quintet2);
        
        try {
            quintet2.value(8);
            assertTrue(false);
        } catch (final IndexOutOfBoundsException e) {
            // OK
        } catch (Exception e) {
            throw e;
        }
        
        
        
        final List<Tuple> tuples = new ArrayList<Tuple>();
        tuples.add(Quintet.of(0, 87, 21, 2, 2));
        tuples.add(Quintet.of(0, 1, 1, 4, 1));
        tuples.add(Quintet.of(0, 1, 1, 4, 0));
        tuples.add(Quintet.of(0, 1, 1, 4, 2));
        tuples.add(Quintet.of(24, 12, 99, 0, 14));
        tuples.add(Quintet.of(24, 12, 84, 4, 2));
        tuples.add(Quartet.of(24, 12, 84, 4));
        tuples.add(Quartet.of(24, 12, 84, 3));
        tuples.add(Quartet.of(24, 12, 84, 0));
        tuples.add(Quartet.of(25, 2, 84, 0));
        tuples.add(Quartet.of(22, 12, 84, 9));
        tuples.add(Sextet.of(0, 0, 0, 0, 0, 0));
        tuples.add(Sextet.of(0, 0, 0, 2, 0, 0));
        tuples.add(Sextet.of(0, 87, 21, 2, 1, 0));
        
        System.out.println("-");
        for (final Tuple tuple : tuples) {
            System.out.println(tuple);
        }
        Collections.sort(tuples);
        System.out.println("-");
        for (final Tuple tuple : tuples) {
            System.out.println(tuple);
        }
        System.out.println("-");
        
    }
    
    

}
