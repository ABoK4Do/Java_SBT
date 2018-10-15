package ru.study.linkedlist;

public class CustomLinkedList<E> {
    Entity<E> start = null;
    Entity<E> end = null;
    int size = 0;

    public void add(E e) {
        Entity<E> loc = new Entity<>(e);
        if (end != null) {
            loc.previous = end;
            end.next = loc;
        }
        end = loc;
        if (start == null) start = loc;
        size++;
    }

    public void add(int index, E e) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Entity cur = start;
        for (int i = 0; i <= index - 1; i++) {
            cur = cur.next;
        }
        Entity<E> loc = new Entity<>(e);
        loc.previous = cur;
        loc.next = cur.next;
        cur.next = loc;
        if(cur == end) end = loc;
        size++;
    }

    public E get(int index){
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Entity<E> cur = start;
        for (int i = 0; i <= index - 1; i++) {
            cur = cur.next;
        }
        return cur.info;
    }

    private class Entity<E> {
        Entity<E> next;
        Entity<E> previous;
        E info;

        Entity(E info) {
            this.info = info;
        }

        Entity(Entity<E> previous, Entity<E> next, E info) {
            this.next = next;
            this.previous = previous;
            this.info = info;
        }
    }


}

