/*
 * Copyright (c) 2017. Phasmid Software
 */

package com.phasmidsoftware.dsaipg.sort.linearithmic;

import com.phasmidsoftware.dsaipg.sort.generic.Sort;
import com.phasmidsoftware.dsaipg.util.config.Config;
import org.junit.Test;

import static com.phasmidsoftware.dsaipg.util.config.Config_Benchmark.setupConfig;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
public class QuickSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] xs = new Integer[4];
        xs[0] = 3;
        xs[1] = 4;
        xs[2] = 2;
        xs[3] = 1;
        final Config config = setupConfig("false", "false", "", "0", "1", "");
        Sort<Integer> s = new QuickSort_3way<Integer>(config);
        Integer[] ys = s.sort(xs);
        assertEquals(Integer.valueOf(1), ys[0]);
        assertEquals(Integer.valueOf(2), ys[1]);
        assertEquals(Integer.valueOf(3), ys[2]);
        assertEquals(Integer.valueOf(4), ys[3]);
    }

    @Test
    public void testPartition() throws Exception {
        String testString = "PABXWPPVPDPCYZ";
        char[] charArray = testString.toCharArray();
        Character[] array = new Character[charArray.length];
        for (int i = 0; i < array.length; i++) array[i] = charArray[i];
        Sort<Character> s = new QuickSort_3way<Character>(Config.load(getClass()));
        Partition<Character> p = ((QuickSort<Character>) s).createPartition(array, 0, array.length - 1);
        assertEquals(0, p.from);
        assertEquals(13, p.to);
        assertEquals(Character.valueOf('P'), array[0]);
        assertEquals(Character.valueOf('Z'), array[array.length - 1]);
    }

}