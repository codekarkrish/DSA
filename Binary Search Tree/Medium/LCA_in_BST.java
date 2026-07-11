import java.util.*;

public class LCA_in_BST {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public TreeNode lca(TreeNode root, int p, int q) {

        while (root != null) {

            if (p < root.data && q < root.data) {
                root = root.left;
            } 
            else if (p > root.data && q > root.data) {
                root = root.right;
            } 
            else {
                return root;
            }
        }

        return null;
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.print("BST: ");
        inorder(root);
        System.out.println();

        int p = 2;
        int q = 4;

        LCA_in_BST obj = new LCA_in_BST();
        TreeNode ans = obj.lca(root, p, q);

        System.out.println("LCA of " + p + " and " + q + " is: " + ans.data);
    }
}

// Time Complexity: O(H), where H is the height of the BST.
// Space Complexity: O(1)