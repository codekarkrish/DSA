import java.util.*;

public class Balanced_Binary_Tree {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to check if the tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    // Function to calculate height
    private static int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
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

        if (isBalanced(root))
            System.out.println("The tree is balanced.");
        else
            System.out.println("The tree is not balanced.");
    }
}

/*  
Time Complexity: O(N), where N is the number of nodes in the Binary Tree. Each node is visited exactly once during the postorder traversal.

Space Complexity: O(1), since no extra data structures are used that grow with input size. However, O(H) auxiliary space is used by the 
recursion stack, where H is the height of the tree. In the best case (balanced tree), H = log₂N; in the worst case (skewed tree), H = N.

*/