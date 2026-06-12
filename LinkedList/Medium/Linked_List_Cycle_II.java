public class Linked_List_Cycle_II {

    // Definition for singly linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to detect the starting node of the cycle
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Move slow to head
                slow = head;

                // Find starting point of cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    // Driver code
    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create cycle: last node points to node with value 2
        head.next.next.next.next = head.next;

        ListNode result = detectCycle(head);

        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.val);
        } else {
            System.out.println("No cycle found");
        }
    }
}

/*
Approach: Floyd's Cycle Detection Algorithm (Tortoise & Hare)
1. Use slow and fast pointers to detect a cycle.
2. If they meet, reset slow to head.
3. Move both pointers one step at a time.
4. The node where they meet again is the start of the cycle.

Time Complexity: O(N)
Space Complexity: O(1)
*/