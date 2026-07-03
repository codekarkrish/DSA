import java.util.ArrayList;
import java.util.List;

public class Preorder_Traversal {

    // Definition for Binary Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Recursive Preorder Traversal
    public static void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        ans.add(root.data);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void main(String[] args) {

        // Creating Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = preorder(root);

        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/