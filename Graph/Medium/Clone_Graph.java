import java.util.*;

public class Clone_Graph {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        // Graph:
        // 1 -- 2
        // |    |
        // 4 -- 3

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Clone_Graph solution = new Clone_Graph();
        Node clone = solution.cloneGraph(n1);

        System.out.println("Original Node: " + n1.val);
        System.out.println("Cloned Node: " + clone.val);
        System.out.print("Neighbors of Cloned Node: ");

        for (Node neighbor : clone.neighbors) {
            System.out.print(neighbor.val + " ");
        }
    }
}

/*
TC: O(V + E)
SC: O(V)
*/