import java.util.*;

// Construct a Binary Tree from Preorder and Inorder Traversal
public class Construct_a_BT_from_Preorder_and_Inorder {

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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }

            return build(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1, inMap);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd,int[] inorder, int inStart, int inEnd,Map<Integer, Integer> inMap) {

            if (preStart > preEnd || inStart > inEnd)
                return null;

            TreeNode root = new TreeNode(preorder[preStart]);

            int inRoot = inMap.get(root.data);
            int leftSize = inRoot - inStart;

            root.left = build(preorder, preStart + 1, preStart + leftSize,inorder, inStart, inRoot - 1, inMap);

            root.right = build(preorder, preStart + leftSize + 1, preEnd,inorder, inRoot + 1, inEnd, inMap);

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

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution sol = new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.print("Inorder Traversal: ");
        printInorder(root);
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)

N = Number of nodes
*/