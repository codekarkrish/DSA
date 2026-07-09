public class Symmetric_Tree {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        return left.data == right.data
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        if (isSymmetric(root))
            System.out.println("Tree is Symmetric");
        else
            System.out.println("Tree is Not Symmetric");
    }
}