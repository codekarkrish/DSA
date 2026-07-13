import java.util.*;

public class BST_iterator {

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
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode node = stack.pop();
            pushAll(node.right);
            return node.data;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator it = new BSTIterator(root);

        System.out.print("BST Iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

/*
Time Complexity:
Constructor: O(H)
next(): O(1) amortized
hasNext(): O(1)

Space Complexity: O(H)
*/