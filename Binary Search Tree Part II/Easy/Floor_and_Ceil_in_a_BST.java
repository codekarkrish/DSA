import java.util.*;

public class Floor_and_Ceil_in_a_BST {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = -1;
        int ceil = -1;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.data == key) {
                floor = curr.data;
                ceil = curr.data;
                break;
            } else if (key < curr.data) {
                ceil = curr.data;
                curr = curr.left;
            } else {
                floor = curr.data;
                curr = curr.right;
            }
        }

        return Arrays.asList(floor, ceil);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int key = 11;

        List<Integer> ans = floorCeilOfBST(root, key);
        System.out.println("Floor = " + ans.get(0));
        System.out.println("Ceil = " + ans.get(1));
    }
}

/*
Time Complexity: O(H)
Space Complexity: O(1)

H = Height of the BST
Balanced BST: O(log N)
Worst Case (Skewed BST): O(N)
*/