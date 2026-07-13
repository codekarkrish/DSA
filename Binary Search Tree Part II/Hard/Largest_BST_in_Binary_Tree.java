public class Largest_BST_in_Binary_Tree {

    // Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Helper class
    static class NodeValue {
        int minNode, maxNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    // Solution
    static class Solution {

        private NodeValue solve(TreeNode root) {
            if (root == null)
                return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

            NodeValue left = solve(root.left);
            NodeValue right = solve(root.right);

            if (left.maxNode < root.data && root.data < right.minNode) {
                return new NodeValue(
                        Math.min(root.data, left.minNode),
                        Math.max(root.data, right.maxNode),
                        left.maxSize + right.maxSize + 1
                );
            }

            return new NodeValue(
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE,
                    Math.max(left.maxSize, right.maxSize)
            );
        }

        public int largestBST(TreeNode root) {
            return solve(root).maxSize;
        }
    }

    // Inorder Traversal
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                 50
                /  \
              30    60
             / \   / \
            5  20 45 70
                     / \
                    65 80
        */

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);

        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);

        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        Solution obj = new Solution();

        System.out.println("Size of Largest BST: " + obj.largestBST(root));
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(H)
*/