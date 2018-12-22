package ru.study.homeWork.countmap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountMapImplTest {
    private CountMap<Integer> map;

    @Before
    public void init(){
        map = new CountMapIml<>();
    }

    @Test
    public void testCounter(){
        map.remove(10);
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        assertEquals(2, map.getCount(5));
        assertEquals(1, map.getCount(6));
        assertEquals(3, map.getCount(10));
    }
}
