public class ConvertSortedArraytoBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree obj = new ConvertSortedArraytoBinarySearchTree();

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = obj.sortedArrayToBST(nums);

        System.out.print("Preorder Traversal: ");
        preorder(root);
    }
}

/*
Time Complexity: O(n)
- Each element is visited exactly once.

Space Complexity: O(log n)
- Recursive call stack height for a balanced BST.
*/