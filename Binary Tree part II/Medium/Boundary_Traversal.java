import java.util.*;

public class Boundary_Traversal {

    // Binary Tree Node
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    // Check if node is a leaf
    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    // Add left boundary (excluding leaf nodes)
    void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;

        while (curr != null) {

            if (!isLeaf(curr))
                res.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    // Add all leaf nodes
    void addLeaves(TreeNode root, List<Integer> res) {

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        if (root.left != null)
            addLeaves(root.left, res);

        if (root.right != null)
            addLeaves(root.right, res);
    }

    // Add right boundary (excluding leaf nodes)
    void addRightBoundary(TreeNode root, List<Integer> res) {

        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();

        while (curr != null) {

            if (!isLeaf(curr))
                temp.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        // Add in reverse order
        for (int i = temp.size() - 1; i >= 0; i--)
            res.add(temp.get(i));
    }

    // Boundary Traversal
    public List<Integer> boundary(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        // Add root if it is not a leaf
        if (!isLeaf(root))
            res.add(root.data);

        // Add left boundary
        addLeftBoundary(root, res);

        // Add leaf nodes
        addLeaves(root, res);

        // Add right boundary
        addRightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Boundary_Traversal obj = new Boundary_Traversal();

        List<Integer> ans = obj.boundary(root);

        System.out.println(ans);
    }
}

/*
TC: O(N) no.of nodes 

SC: O(N)
Result list + Recursive stack
*/