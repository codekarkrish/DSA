import java.util.*;

public class Maximum_Depth_in_BT {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Maximum Depth using Level Order Traversal
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
                  \
                   6
                    \
                     7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        System.out.println("Maximum Depth: " + maxDepth(root));
    }
}

/*  Time Complexity: O(N), each node is processed once in Level Order Traversal.
Space Complexity: O(N), in worst case, a maximum of N/2 nodes can be present in queue.
 */