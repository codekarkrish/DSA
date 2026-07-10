public class SearchinBST {

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

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.data != val) {
            if (val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        SearchinBST obj = new SearchinBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = obj.searchBST(root, 2);

        if (result != null) {
            System.out.println("Node found: " + result.data);
        } else {
            System.out.println("Node not found");
        }
    }
}

/*
Time Complexity: O(log n) average, O(n) worst case
Space Complexity: O(1)
*/