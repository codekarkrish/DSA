public class Reverse_Nodes_in_k_Group {

    // Definition for singly linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse nodes in groups of k
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kth = getKthNode(groupPrev, k);

            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            // Reverse current group
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect reversed group
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    // Helper function to get the kth node
    private static ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create Linked List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.print("Original List: ");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.print("Reversed in Groups of " + k + ": ");
        printList(head);
    }
}