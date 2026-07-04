import java.util.*;

// TreeNode structure
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

public class Bottom_view_of_BT {

    // Pair class to store node and its horizontal distance
    static class Pair {
        TreeNode node;
        int line;

        Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    // Function to return Bottom View
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int line = p.line;

            // Overwrite to keep the bottom-most node
            map.put(line, node.data);

            if (node.left != null) {
                q.offer(new Pair(node.left, line - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, line + 1));
            }
        }

        ans.addAll(map.values());
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List<Integer> ans = bottomView(root);

        System.out.print("Bottom View: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}

/*
Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the BFS traversal.

Space Complexity: O(N/2 + N/2) where N represents the number of nodes in the Binary Tree.
*/