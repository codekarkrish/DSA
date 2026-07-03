import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder_Traversal {

    // Definition for a binary tree node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Iterative Inorder Traversal
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }

        return inorder;
    }

    public static void main(String[] args) {

        // Creating Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> ans = inorder(root);

        System.out.print("Inorder Traversal: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(h)
*/