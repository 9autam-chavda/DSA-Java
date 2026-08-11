package Hashing;
import java.util.LinkedList;

public class implHashing {
    static class HashMap<K, V> { // here <K,V> are generic types
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private int capacity;
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.capacity = 16;
            this.size = 0;
            this.buckets = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int getBucketIndex(K key) {
            return Math.abs(key.hashCode()) % capacity;
        }

        public void put(K key, V value) {
            int index = getBucketIndex(key);
            LinkedList<Node> bucket = buckets[index];

            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }

            bucket.add(new Node(key, value));
            size++;
        }

        public V get(K key) {
            int index = getBucketIndex(key);
            LinkedList<Node> bucket = buckets[index];

            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }

            return null; // Key not found
        }

        public boolean containsKey(K key) {
            int index = getBucketIndex(key);
            LinkedList<Node> bucket = buckets[index];

            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    return true;
                }
            }

            return false;
        }
    }
}
