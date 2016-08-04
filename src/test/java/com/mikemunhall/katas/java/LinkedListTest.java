package com.mikemunhall.katas.java;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTest {

    @Test
    public void newLinkedListHasSizeZeroAndDataNull() {
        LinkedList ll = new LinkedList();
        assertEquals((int) ll.size(), 0);
        assertNull(ll.get(0).getData());
    }

    @Test
    public void addToLinkedListUpdatesSizeAndData() {
        LinkedList ll = new LinkedList();

        ll.add(0);
        assertEquals((int) ll.size(), 1);
        assertEquals(ll.get(0).getData(), 0);

        ll.add(1);
        assertEquals((int) ll.size(), 2);
        assertEquals(ll.get(0).getData(), 0);
        assertEquals(ll.get(1).getData(), 1);

        ll.add(2);
        assertEquals((int) ll.size(), 3);
        assertEquals(ll.get(0).getData(), 0);
        assertEquals(ll.get(1).getData(), 1);
        assertEquals(ll.get(2).getData(), 2);
    }

    @Test
    public void removeFromLinkedListRemovesFromMiddle() {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.remove(2);
        assertEquals((int) ll.size(), 4);
        assertEquals(ll.get(0).getData(), 0);
        assertEquals(ll.get(1).getData(), 1);
        assertEquals(ll.get(2).getData(), 3);
        assertEquals(ll.get(3).getData(), 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void removeFromEmptyLinkedListThrowsException() {
        LinkedList ll1 = new LinkedList();
        ll1.remove(5);
        fail("not implemented");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void removeFromLinkedListOutOfBoundsThrowsException() {
        LinkedList ll2 = new LinkedList();
        ll2.add(0);
        ll2.add(1);
        ll2.remove(5);
    }

    @Test
    public void removeFromLinkedListRemovesFirstOnlyOneElement() {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.remove(0);
        assertEquals((int) ll.size(), 0);
        assertNull(ll.get(0).getData());
    }

    @Test
    public void removeFromLinkedListRemovesFirstManyElements() {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.remove(0);
        assertEquals((int) ll.size(), 1);
        assertEquals(ll.get(0).getData(), 1);
    }

    @Test
    public void removeFromLinkedListRemovesLast() {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.remove(2);
        assertEquals((int) ll.size(), 2);
        assertEquals(ll.get(0).getData(), 0);
        assertEquals(ll.get(1).getData(), 1);
        assertFalse(ll.get(1).hasNext());
    }
}
