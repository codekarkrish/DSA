import java.util.*;

public class Diameter_of_Binary_Tree {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to find diameter
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    // Function to calculate height
    private static int height(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
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

        System.out.println("Diameter of Binary Tree: " + diameterOfBinaryTree(root));
    }
}

/* 
Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the postorder traversal.

Space Complexity : O(1) as no additional space or data structures is created that is proportional to the input size of the tree
*/