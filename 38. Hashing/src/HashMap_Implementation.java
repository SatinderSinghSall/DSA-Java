// Hashing: HashMap Implementation.

import java.util.LinkedList;

class HashMap_Implementation<K, V> {

    // Node class (key-value pair)
    class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; // number of key-value pairs
    private int capacity = 4; // initial bucket size
    private LinkedList<Node>[] buckets;

    // Constructor
    @SuppressWarnings("unchecked")
    public HashMap_Implementation() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Put method
    public void put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // update
                return;
            }
        }

        bucket.add(new Node(key, value));
        size++;
    }

    // Get method
    public V get(K key) {
        int index = hashFunction(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    // Remove method
    public V remove(K key) {
        int index = hashFunction(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return node.value;
            }
        }

        return null;
    }

    // Display method
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            for (Node node : buckets[i]) {
                System.out.println(node.key + " = " + node.value);
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        HashMap_Implementation<String, Integer> map = new HashMap_Implementation<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        System.out.println("Value for Apple: " + map.get("Apple"));

        map.remove("Banana");

        map.display();
    }
}
