public class Populating_Next_Right_Pointers_in_EachNode {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {

            Node curr = leftMost;

            while (curr != null) {

                curr.left.next = curr.right;

                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }

    public static void printLevels(Node root) {

        Node levelStart = root;

        while (levelStart != null) {

            Node curr = levelStart;

            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }

            System.out.println("#");

            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {

        Populating_Next_Right_Pointers_in_EachNode obj =
                new Populating_Next_Right_Pointers_in_EachNode();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        obj.connect(root);

        printLevels(root);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/