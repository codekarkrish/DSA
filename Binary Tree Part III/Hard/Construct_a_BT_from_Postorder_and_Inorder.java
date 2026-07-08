import java.util.*;

public class Construct_a_BT_from_Postorder_and_Inorder {

    // Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            data = val;
            left = right = null;
        }
    }

    // Solution
    static class Solution {

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            Map<Integer, Integer> inMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }

            return build(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1, inMap);
        }

        private TreeNode build(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd,
                               Map<Integer, Integer> inMap) {

            if (inStart > inEnd || postStart > postEnd)
                return null;

            TreeNode root = new TreeNode(postorder[postEnd]);

            int inRoot = inMap.get(root.data);
            int leftSize = inRoot - inStart;

            root.left = build(inorder, inStart, inRoot - 1,
                              postorder, postStart, postStart + leftSize - 1, inMap);

            root.right = build(inorder, inRoot + 1, inEnd,
                               postorder, postStart + leftSize, postEnd - 1, inMap);

            return root;
        }
    }

    // Inorder Traversal
    static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // Driver Code
    public static void main(String[] args) {

        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};

        Solution sol = new Solution();
        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.print("Inorder Traversal: ");
        printInorder(root);
    }
}

/*

Time Complexity: O(N), Every node is visited once.

Space Complexity: O(N), Due to hashmap and recursion stack (up to tree height).
*/