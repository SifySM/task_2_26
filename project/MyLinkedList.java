package edu.vsu.ru.project;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>  {

    private MyLinkedListNode head = null;
    private MyLinkedListNode tail = null;
    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        class MyLinkedListIterator implements Iterator<T> {
            MyLinkedListNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new MyLinkedListIterator();
    }



    public void addFirst(T value) {
        head = new MyLinkedListNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new MyLinkedListNode(value);
        } else {
            tail.next = new MyLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkForEmpty() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
    }

    private MyLinkedListNode getNode(int index) {
        MyLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }

    public void removeFirst() throws IndexOutOfBoundsException {
        checkForEmpty();
        head = head.next;
        if (size == 1) {
            tail = head;
        }
        size--;
    }

    public void removeLast() throws IndexOutOfBoundsException {
        checkForEmpty();
        if (size == 0) {
            head = tail = null;
        } else {
            tail = findCurrElement(size - 2);
        }
    }

    private MyLinkedListNode findCurrElement(int index) {
        MyLinkedListNode curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) removeFirst();
        else {
            MyLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).value;
    }



    public T getFirst() throws IndexOutOfBoundsException {
        checkForEmpty();
        return head.value;
    }

    public T getLast() throws IndexOutOfBoundsException {
        checkForEmpty();
        return tail.value;
    }

    public MyLinkedList<T> convert() {
        Iterator<T> it0n = this.iterator();
        Iterator<T> it1n = this.iterator();
        Iterator<T> it2n = this.iterator();

        int n = size / 3;
        for (int i = 0; i < n; i++) {
             it1n.next();
             it2n.next();
        }

        for (int i = 0; i < n; i++) {
            it2n.next();
        }

        MyLinkedList<T> sortList = new MyLinkedList<T>();

        for (int i = 0; i < n; i++) {
            sortList.addLast(it0n.next());
            sortList.addLast(it1n.next());
            sortList.addLast(it2n.next());
        }

        return sortList;
    }

    private class MyLinkedListNode {
        public T value;
        public MyLinkedListNode next;

        public MyLinkedListNode(T value, MyLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public MyLinkedListNode(T value) {
            this(value, null);
        }
    }
}
