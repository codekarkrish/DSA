import java.util.*;

public class Validate_Binary_Search_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {

        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return validate(root.left, min, root.val) &&
               validate(root.right, root.val, max);
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.print("Tree (Inorder): ");
        inorder(root);
        System.out.println();

        Validate_Binary_Search_Tree obj = new Validate_Binary_Search_Tree();

        if (obj.isValidBST(root))
            System.out.println("Valid Binary Search Tree");
        else
            System.out.println("Not a Binary Search Tree");
    }
}

// Time Complexity: O(N), where N is the number of nodes.
// Space Complexity: O(H), where H is the height of the tree.