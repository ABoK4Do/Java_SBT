package ru.study.homeWork.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomLinkedListTest {
    CustomLinkedList<String> customLinkedList;

    @Before
    public void init() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void zeroSize() {
        assertEquals(0, customLinkedList.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void emptyList() {
        customLinkedList.get(0);
    }

    @Test
    public void addTwoEntityAndOneByIndex() {
        customLinkedList.add("One");
        customLinkedList.add("Two");
        customLinkedList.add(0, "Three");
        assertEquals(3, customLinkedList.size());
        assertEquals("Three", customLinkedList.get(1));
        assertEquals("Two", customLinkedList.get(2));
        assertEquals("One;Three;Two", customLinkedList.toString());
    }
}
