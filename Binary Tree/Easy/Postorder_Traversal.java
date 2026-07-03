import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder_Traversal {

    // Definition for Binary Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Iterative Postorder Traversal (Using Two Stacks)
    public static List<Integer> postorder(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        if (root == null) return postorder;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);

            if (node.left != null) st1.push(node.left);
            if (node.right != null) st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            postorder.add(st2.pop().data);
        }

        return postorder;
    }

    public static void main(String[] args) {

        // Creating Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = postorder(root);

        System.out.print("Postorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/