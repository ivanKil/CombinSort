package lesson4;

public interface Deque<E> {

    void insertLeft(E value);

    void insertRight(E value);

    void insert(E value, int ind);

    E removeLeft();

    E removeRight();

    E getFirst();

    E getLast();

    int size();

    boolean isEmpty();

    void display();

    class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String prevValue = prev == null ? "null" : prev.item.toString();
            String nextValue = next == null ? "null" : next.item.toString();
            sb.append(item).append("(").append(prevValue).append(",").append(nextValue).append(")");
            return sb.toString();
        }
    }
}