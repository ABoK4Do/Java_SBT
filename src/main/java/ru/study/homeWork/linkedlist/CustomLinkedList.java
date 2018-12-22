package ru.study.homeWork.linkedlist;

public class CustomLinkedList<E> {
    private Entity<E> start = null;
    private Entity<E> end = null;
    private int size = 0;

    public void add(E e) {
        Entity<E> local = new Entity<>(e);
        if (end != null) {
            local.previous = end;
            end.next = local;
        }
        end = local;
        if (start == null) start = local;
        size++;
    }

    public void add(int index, E e) {
        Entity<E> current = getEntityByIndex(index);
        Entity<E> local = new Entity<>(e);
        local.previous = current;
        local.next = current.next;
        current.next = local;
        if (current == end) end = local;
        size++;
    }

    public E get(int index) {
        return getEntityByIndex(index).info;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Entity<E> current = start;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (result.length() != 0) result.append(";");
            result.append(current.toString());
            current = current.next;
        }
        return result.toString();
    }

    private Entity<E> getEntityByIndex(int index) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Entity<E> current = start;
        for (int i = 0; i <= index - 1; i++) {
            current = current.next;
        }
        return current;
    }

    private class Entity<E> {
        Entity<E> next;
        Entity<E> previous;
        E info;

        Entity(E info) {
            this.info = info;
        }

        public String toString() {
            return info.toString();
        }
    }


}

