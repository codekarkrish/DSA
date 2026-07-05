import java.util.*;

public class Pre_Post_Inorder_in_one_traversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static List<List<Integer>> treeTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            ans.add(in);
            ans.add(pre);
            ans.add(post);
            return ans;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair cur = st.pop();

            if (cur.state == 1) {
                pre.add(cur.node.data);
                cur.state = 2;
                st.push(cur);

                if (cur.node.left != null) {
                    st.push(new Pair(cur.node.left, 1));
                }
            } else if (cur.state == 2) {
                in.add(cur.node.data);
                cur.state = 3;
                st.push(cur);

                if (cur.node.right != null) {
                    st.push(new Pair(cur.node.right, 1));
                }
            } else {
                post.add(cur.node.data);
            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }

    static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<List<Integer>> traversals = treeTraversal(root);

        System.out.print("Inorder Traversal: ");
        printList(traversals.get(0));

        System.out.print("Preorder Traversal: ");
        printList(traversals.get(1));

        System.out.print("Postorder Traversal: ");
        printList(traversals.get(2));
    }
}

/*
Time Complexity: O(3N)
Reason: Every node is processed three times.

Space Complexity: O(4N)
Reason: O(N) stack + O(N) preorder + O(N) inorder + O(N) postorder.
*/