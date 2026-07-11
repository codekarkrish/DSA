import java.util.*;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {

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

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {

        if (index == preorder.length || preorder[index] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = build(preorder, root.data);
        root.right = build(preorder, bound);

        return root;
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        Construct_Binary_Search_Tree_from_Preorder_Traversal obj =
                new Construct_Binary_Search_Tree_from_Preorder_Traversal();

        TreeNode root = obj.bstFromPreorder(preorder);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}

// Time Complexity: O(N), where N is the number of nodes.
// Space Complexity: O(H), where H is the height of the BST (recursion stack).