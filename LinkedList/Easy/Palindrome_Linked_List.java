public class Palindrome_Linked_List {

    // Definition for singly linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Reverse a linked list recursively
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        ListNode front = head.next;

        front.next = head;
        head.next = null;

        return newHead;
    }

    // Check if linked list is palindrome
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode secondHalf = reverse(slow.next);

        ListNode first = head;
        ListNode second = secondHalf;

        // Compare both halves
        while (second != null) {
            if (first.val != second.val) {
                reverse(secondHalf); // Restore list
                return false;
            }

            first = first.next;
            second = second.next;
        }

        // Restore list
        reverse(secondHalf);
        return true;
    }

    // Print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.print("Linked List: ");
        printList(head);

        if (isPalindrome(head)) {
            System.out.println("Palindrome Linked List");
        } else {
            System.out.println("Not a Palindrome Linked List");
        }
    }
}

/*
Approach: Find middle → Reverse second half → Compare both halves → Restore list

Time Complexity: O(N)

Space Complexity: O(N) (recursive reverse uses recursion stack)
*/