import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_and_Largest_element_in_BST {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class Solution {
        private int k;
        private int result;

        private void inorder(TreeNode node) {
            if (node != null) {
                inorder(node.left);
                if (--k == 0) {
                    result = node.data;
                    return;
                }
                inorder(node.right);
            }
        }

        private void reverseInorder(TreeNode node) {
            if (node != null) {
                reverseInorder(node.right);
                if (--k == 0) {
                    result = node.data;
                    return;
                }
                reverseInorder(node.left);
            }
        }

        private int kthSmallest(TreeNode root, int k) {
            this.k = k;
            this.result = -1;
            inorder(root);
            return result;
        }

        private int kthLargest(TreeNode root, int k) {
            this.k = k;
            this.result = -1;
            reverseInorder(root);
            return result;
        }

        public List<Integer> kLargesSmall(TreeNode root, int k) {
            List<Integer> ans = new ArrayList<>();
            ans.add(kthSmallest(root, k));
            ans.add(kthLargest(root, k));
            return ans;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Solution sol = new Solution();

        int k = 1;
        List<Integer> ans = sol.kLargesSmall(root, k);

        System.out.println("Kth Smallest: " + ans.get(0));
        System.out.println("Kth Largest: " + ans.get(1));
    }
}

/*
Time Complexity: O(N), where N is the number of nodes in the binary tree.
The inorder and reverse inorder traversals each visit every node once in the worst case.

Space Complexity: O(H), where H is the height of the binary tree.
*/