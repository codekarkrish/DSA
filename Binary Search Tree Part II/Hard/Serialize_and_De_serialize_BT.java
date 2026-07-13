import java.util.*;

public class Serialize_and_De_serialize_BT {

    // Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Codec
    static class Codec {

        // Serialize
        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode node = q.poll();

                if (node == null) {
                    sb.append("#,");
                } else {
                    sb.append(node.data).append(",");
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            return sb.toString();
        }

        // Deserialize
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;

            String[] arr = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int i = 1;

            while (!q.isEmpty() && i < arr.length) {
                TreeNode node = q.poll();

                if (!arr[i].equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(node.left);
                }
                i++;

                if (i < arr.length && !arr[i].equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(node.right);
                }
                i++;
            }

            return root;
        }
    }

    // Inorder Traversal
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
                 / \
                4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();

        System.out.print("Original Tree (Inorder): ");
        inorder(root);
        System.out.println();

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);

        System.out.print("Deserialized Tree (Inorder): ");
        inorder(deserialized);
        System.out.println();
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)
*/