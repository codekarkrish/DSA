import java.util.*;

public class Two_sum_in_BST {

    // Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // BST Iterator
    static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        boolean reverse;

        BSTIterator(TreeNode root, boolean reverse) {
            this.reverse = reverse;
            pushAll(root);
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = reverse ? node.right : node.left;
            }
        }

        int next() {
            TreeNode node = stack.pop();

            if (reverse)
                pushAll(node.left);
            else
                pushAll(node.right);

            return node.data;
        }
    }

    // Solution
    static class Solution {

        public boolean twoSumBST(TreeNode root, int k) {
            if (root == null) return false;

            BSTIterator left = new BSTIterator(root, false);
            BSTIterator right = new BSTIterator(root, true);

            int i = left.next();
            int j = right.next();

            while (i < j) {
                int sum = i + j;

                if (sum == k)
                    return true;
                else if (sum < k)
                    i = left.next();
                else
                    j = right.next();
            }

            return false;
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

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        System.out.print("BST: ");
        inorder(root);
        System.out.println();

        Solution obj = new Solution();

        int target = 22;

        if (obj.twoSumBST(root, target))
            System.out.println("Pair with sum " + target + " exists.");
        else
            System.out.println("Pair with sum " + target + " does not exist.");
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(H)
*/