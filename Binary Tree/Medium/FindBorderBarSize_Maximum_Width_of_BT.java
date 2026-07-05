import java.util.*;

public class FindBorderBarSize_Maximum_Width_of_BT {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        long index;

        Pair(Node node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    static int widthOfBinaryTree(Node root) {

        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().index;

            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                long currIndex = cur.index - minIndex;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (cur.node.left != null) {
                    q.offer(new Pair(cur.node.left, 2 * currIndex + 1));
                }

                if (cur.node.right != null) {
                    q.offer(new Pair(cur.node.right, 2 * currIndex + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }

        return maxWidth;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);

        System.out.println("Maximum Width: " + widthOfBinaryTree(root));
    }
}

/*
Time Complexity: O(N)
Reason: Every node is processed once.

Space Complexity: O(N)
Reason: Queue stores at most one level of the tree.
*/