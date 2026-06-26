import java.util.HashMap;
import java.util.Map;

public class LFU_Cache {

    // Node of Doubly Linked List
    static class Node {
        int key, value, cnt;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }

    // Doubly Linked List
    static class List {
        int size;
        Node head, tail;

        List() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Add node at front
        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        // Remove a node
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    // LFU Cache Class
    static class LFUCache {

        private Map<Integer, Node> keyNode;
        private Map<Integer, List> freqListMap;
        private int maxSizeCache;
        private int minFreq;
        private int curSize;

        public LFUCache(int capacity) {
            maxSizeCache = capacity;
            minFreq = 0;
            curSize = 0;
            keyNode = new HashMap<>();
            freqListMap = new HashMap<>();
        }

        // Update node frequency
        private void updateFreqListMap(Node node) {

            keyNode.remove(node.key);

            freqListMap.get(node.cnt).removeNode(node);

            if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
                minFreq++;
            }

            List nextList = freqListMap.getOrDefault(node.cnt + 1, new List());

            node.cnt++;

            nextList.addFront(node);

            freqListMap.put(node.cnt, nextList);
            keyNode.put(node.key, node);
        }

        // Get value
        public int get(int key) {

            if (!keyNode.containsKey(key))
                return -1;

            Node node = keyNode.get(key);
            int value = node.value;

            updateFreqListMap(node);

            return value;
        }

        // Put key-value
        public void put(int key, int value) {

            if (maxSizeCache == 0)
                return;

            if (keyNode.containsKey(key)) {

                Node node = keyNode.get(key);
                node.value = value;
                updateFreqListMap(node);

            } else {

                if (curSize == maxSizeCache) {

                    List list = freqListMap.get(minFreq);
                    keyNode.remove(list.tail.prev.key);
                    list.removeNode(list.tail.prev);
                    curSize--;
                }

                curSize++;
                minFreq = 1;

                List list = freqListMap.getOrDefault(minFreq, new List());

                Node node = new Node(key, value);
                list.addFront(node);

                keyNode.put(key, node);
                freqListMap.put(minFreq, list);
            }
        }
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.print(cache.get(1) + " "); // 1

        cache.put(3, 3);

        System.out.print(cache.get(2) + " "); // -1
        System.out.print(cache.get(3) + " "); // 3

        cache.put(4, 4);

        System.out.print(cache.get(1) + " "); // -1
        System.out.print(cache.get(3) + " "); // 3
        System.out.print(cache.get(4));       // 4
    }
}

 /*
 Time Complexity: O(N), where N is the number of queries on the LFU cache. Each get and put method takes an average of constant time, making the overall complexity O(N).

Space Complexity: O(cap), where cap is the capacity of the LFU cache. The cache can store a maximum of cap data items, taking O(cap) space.
*/