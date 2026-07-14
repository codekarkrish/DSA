public class Binary_Tree_to_Doubly_Linked_List {

    // Definition for Binary Tree Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private TreeNode prev = null;
    private TreeNode head = null;

    // Converts Binary Tree to Doubly Linked List
    public TreeNode bToDLL(TreeNode root) {
        inorder(root);
        return head;
    }

    // Inorder Traversal
    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        inorder(node.right);
    }

    // Print Doubly Linked List
    public void printDLL(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.right != null) System.out.print(" <-> ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Binary_Tree_to_Doubly_Linked_List obj = new Binary_Tree_to_Doubly_Linked_List();

        /*
                 10
               /    \
             12      15
            /  \    /
          25   30  36
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        TreeNode head = obj.bToDLL(root);

        System.out.println("Doubly Linked List:");
        obj.printDLL(head);
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(H)   // H = Height of the tree (recursive stack)
*/