public class Children_Sum_Property_in_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    static void changeTree(TreeNode root) {

        if (root == null)
            return;

        int child = 0;

        if (root.left != null)
            child += root.left.val;

        if (root.right != null)
            child += root.right.val;

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null)
                root.left.val = root.val;
            else if (root.right != null)
                root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if (root.left != null)
            total += root.left.val;

        if (root.right != null)
            total += root.right.val;

        if (root.left != null || root.right != null)
            root.val = total;
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.print("Before: ");
        inorder(root);
        System.out.println();

        changeTree(root);

        System.out.print("After: ");
        inorder(root);
    }
}

/* Time Complexity: O(N)
Space Complexity: O(H) (Worst: O(N), Balanced: O(log N)) */