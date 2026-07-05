import java.util.*;

public class Print_root_to_leaf_path_in_BT {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static List<List<Integer>> allRootToLeaf(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, path, ans);

        return ans;
    }

    static void dfs(Node root, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;

        path.add(root.data);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, path, ans);
            dfs(root.right, path, ans);
        }

        path.remove(path.size() - 1);
    }

    static void printPaths(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);

        root.left.left = new Node(6);
        root.left.right = new Node(2);

        root.right.left = new Node(0);
        root.right.right = new Node(8);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        List<List<Integer>> paths = allRootToLeaf(root);

        System.out.println("Root to Leaf Paths:");
        printPaths(paths);
    }
}

/*
Time Complexity: O(N)
Reason: Every node is visited once.

Space Complexity: O(N)
Reason: Recursive stack and current path storage.
*/