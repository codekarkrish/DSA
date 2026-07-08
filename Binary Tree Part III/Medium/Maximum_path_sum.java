public class Maximum_path_sum {

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
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxSum;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = Math.max(0, dfs(node.left));
            int right = Math.max(0, dfs(node.right));

            maxSum = Math.max(maxSum, left + right + node.data);

            return Math.max(left, right) + node.data;
        }
    }

    // Driver Code
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();

        System.out.println("Maximum Path Sum: " + sol.maxPathSum(root));
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(H)

N = Number of nodes
H = Height of the binary tree
*/