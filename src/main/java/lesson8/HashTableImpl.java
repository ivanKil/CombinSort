package lesson8;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final Item<K, V>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value, Item<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public HashTableImpl(int intialCapacity) {
        this.data = new Item[intialCapacity];
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int index = hashFunc(key);

        Item<K, V> item = data[index];
        if (item == null) {
            data[index] = new Item<>(key, value, null);
            size++;
            return true;
        } else if (isKeysEquals(item, key)) {
            item.setValue(value);
            size++;
            return true;
        }

        while (item.next != null) {
            if (isKeysEquals(item.next, key)) {
                item.next.setValue(value);
                return true;
            }
            item = item.next;
        }

        item.next = new Item<>(key, value, null);
        size++;
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == null) {
            return false;
        }
        return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1)
            return null;
        Item<K, V> item = data[index];
        if (item == null)
            return null;
        do {
            if (isKeysEquals(item, key)) {
                return item.value;
            }
            item = item.next;
        } while (item != null);
        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        return index % data.length;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);

        Item<K, V> prevItem = null;
        Item<K, V> item = data[index];
        do {
            if (isKeysEquals(item, key)) {
                if (prevItem == null) {
                    data[index] = item.next;
                } else if (item.next != null) {
                    prevItem.next = item.next;
                } else {
                    prevItem.next = null;
                }
                size--;
                return item.value;
            }
            prevItem = item;
            item = item.next;
        } while (item != null);

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------\n");
        for (int i = 0; i < data.length; i++) {
            sb.append("\n ").append(i);
            Item<K, V> item = data[i];
            if (item == null) {
                sb.append(" null");
                continue;
            }
            do {
                sb.append(" ").append(item);
                item = item.next;
            } while (item != null);
        }
        sb.append("\n------------------------\n");
        return sb.toString();
    }
}
