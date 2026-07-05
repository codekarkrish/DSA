import java.util.*;

public class Vertical_Order_Traversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int vertical;
        int level;

        Pair(Node node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            map.putIfAbsent(cur.vertical, new TreeMap<>());
            map.get(cur.vertical).putIfAbsent(cur.level, new PriorityQueue<>());
            map.get(cur.vertical).get(cur.level).offer(cur.node.data);

            if (cur.node.left != null) {
                q.offer(new Pair(cur.node.left, cur.vertical - 1, cur.level + 1));
            }

            if (cur.node.right != null) {
                q.offer(new Pair(cur.node.right, cur.vertical + 1, cur.level + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }

    static void printTraversal(List<List<Integer>> ans) {
        for (List<Integer> list : ans) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        root.right.left = new Node(9);
        root.right.right = new Node(10);

        List<List<Integer>> ans = verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");
        printTraversal(ans);
    }
}

/*
Time Complexity: O(N log N)
Reason: Each node is processed once, and TreeMap/PriorityQueue operations take O(log N).

Space Complexity: O(N)
Reason: TreeMap, PriorityQueue, and BFS queue together store at most N nodes.
*/