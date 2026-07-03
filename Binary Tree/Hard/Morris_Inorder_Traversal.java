import java.util.ArrayList;
import java.util.List;

public class Morris_Inorder_Traversal {

    // Definition for Binary Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Morris Inorder Traversal
    public static List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;

                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
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
        root.left.right.right = new TreeNode(6);

        List<Integer> result = getInorder(root);

        System.out.print("Morris Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

/* 
Time Complexity: O(2N), the time complexity is linear, as each node is visited at most twice (once for establishing the temporary link and once for reverting it).
Space Complexity: O(1), the space complexity is constant, as the algorithm uses only a constant amount of extra space irrespective of the input size.
*/