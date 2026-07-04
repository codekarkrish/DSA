import java.util.ArrayList;
import java.util.List;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Right_Left_View_of_BT {

    // DFS for Left View
    public static void leftDFS(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;

        if (res.size() == level) {
            res.add(node.val);
        }

        leftDFS(node.left, level + 1, res);
        leftDFS(node.right, level + 1, res);
    }

    // DFS for Right View
    public static void rightDFS(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;

        if (res.size() == level) {
            res.add(node.val);
        }

        rightDFS(node.right, level + 1, res);
        rightDFS(node.left, level + 1, res);
    }

    // Left View
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leftDFS(root, 0, res);
        return res;
    }

    // Right View
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightDFS(root, 0, res);
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        List<Integer> left = leftView(root);
        List<Integer> right = rightView(root);

        System.out.print("Left View: ");
        for (int x : left) {
            System.out.print(x + " ");
        }

        System.out.print("\nRight View: ");
        for (int x : right) {
            System.out.print(x + " ");
        }
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(H)
*/