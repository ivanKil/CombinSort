package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleDeque<E> implements Deque<E>, Iterable<E> {
    protected int size;
    protected Node<E> first;
    protected Node<E> last;

    @Override
    public void insertLeft(E value) {
        Node<E> oldFirst = first;
        first = new Node<>(value, null, first);
        if (size == 0) {
            last = first;
        } else if (size == 1) {
            last = oldFirst;
            last.prev = first;
        }
        if (oldFirst != null)
            oldFirst.prev = first;
        size++;
    }

    @Override
    public void insertRight(E value) {
        Node<E> oldLast = last;
        last = new Node<>(value, oldLast, null);
        if (size == 0) {
            first = last;
        } else if (size == 1) {
            first = oldLast;
            first.next = last;
        }
        if (oldLast != null)
            oldLast.next = last;
        size++;
    }

    @Override
    public void insert(E value, int ind) {
        if (ind > size || ind < 0)
            throw new ArrayIndexOutOfBoundsException();
        int i = 0;
        Node<E> cur = first;
        while (i < ind - 1) {
            cur = cur.next;
            i++;
        }
        if (i == 0)
            insertLeft(value);
        else if (i == size - 1)
            insertRight(value);
        else {
            Node<E> newNode = new Node<>(value, cur, cur.next);
            Node<E> nextNode = cur.next;
            cur.next = newNode;
            nextNode.prev = newNode;
            size++;
        }

    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        removedNode.prev = null;
        size--;
        if (last.prev == removedNode)
            last.prev = first;
        if (first != null)
            first.prev = null;
        if (size == 0) {
            first = null;
            last = null;
        }
        return removedNode.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = last;
        last = removedNode.prev;
        removedNode.next = null;
        removedNode.prev = null;
        size--;
        if (first.next == removedNode)
            first.next = last;
        if (last != null)
            last.next = null;
        if (size == 0) {
            first = null;
            last = null;
        }
        return removedNode.item;
    }

    @Override
    public E getFirst() {
        return first == null ? null : first.item;
    }

    @Override
    public E getLast() {
        return last == null ? null : last.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {
        private Node<E> nextNode;

        DequeIterator() {
            nextNode = first;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public E next() {
            if (nextNode == null)
                throw new NoSuchElementException();
            E ret = nextNode.item;
            nextNode = nextNode.next;
            return ret;
        }
    }
}
