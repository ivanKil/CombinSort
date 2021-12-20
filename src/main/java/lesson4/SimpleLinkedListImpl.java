package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);

/*        Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;*/

        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
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
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node<E> nextNode;

        ListIterator() {
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
