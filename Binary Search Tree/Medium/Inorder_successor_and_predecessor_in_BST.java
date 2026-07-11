import java.util.*;

public class Inorder_successor_and_predecessor_in_BST {

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

    List<Integer> succPredBST(TreeNode root, int key) {

        TreeNode predecessor = null;
        TreeNode successor = null;
        TreeNode curr = root;

        // Find predecessor
        while (curr != null) {
            if (key <= curr.data) {
                curr = curr.left;
            } else {
                predecessor = curr;
                curr = curr.right;
            }
        }

        curr = root;

        // Find successor
        while (curr != null) {
            if (key >= curr.data) {
                curr = curr.right;
            } else {
                successor = curr;
                curr = curr.left;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(predecessor != null ? predecessor.data : -1);
        ans.add(successor != null ? successor.data : -1);

        return ans;
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        System.out.print("BST: ");
        inorder(root);
        System.out.println();

        int key = 6;

        Inorder_successor_and_predecessor_in_BST obj =
                new Inorder_successor_and_predecessor_in_BST();

        List<Integer> ans = obj.succPredBST(root, key);

        System.out.println("Predecessor of " + key + " : " + ans.get(0));
        System.out.println("Successor of " + key + " : " + ans.get(1));
    }
}

// Time Complexity: O(H), where H is the height of the BST.
// Space Complexity: O(1)