import java.util.*;

public class LRU_Cache {

    // LRU Cache Class
    static class LRUCache {

        // Doubly Linked List Node
        class Node {
            int key, val;
            Node prev, next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private int cap;
        private HashMap<Integer, Node> map;
        private Node head, tail;

        public LRUCache(int capacity) {
            cap = capacity;
            map = new HashMap<>();

            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        // Add node after head
        private void addNode(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        // Delete a node
        private void deleteNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Get value by key
        public int get(int key) {
            if (!map.containsKey(key))
                return -1;

            Node node = map.get(key);
            deleteNode(node);
            addNode(node);

            return node.val;
        }

        // Put key-value pair
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                deleteNode(node);
                map.remove(key);
            }

            if (map.size() == cap) {
                Node lru = tail.prev;
                deleteNode(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // Evicts key 2
        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // Evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}

/* 
Time Complexity: get() function: O(1), accessing a value in the HashMap is O(1) on average.
put() function: O(1), checking and removing from the map as well as inserting into the doubly linked list is O(1).
Space Complexity: O(capacity) , for storing up to capacity nodes in the doubly linked list and map.
*/