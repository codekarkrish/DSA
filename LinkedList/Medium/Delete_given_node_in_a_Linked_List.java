public class Delete_given_node_in_a_Linked_List {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Function to delete a given node (not the tail node)
    public static void deleteNode(ListNode node) {

        // Copy the value of the next node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }

    // Function to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println("Original Linked List:");
        printList(head);

        // Delete node with value 5
        deleteNode(head.next);

        System.out.println("Linked List after deleting node 5:");
        printList(head);
    }
}