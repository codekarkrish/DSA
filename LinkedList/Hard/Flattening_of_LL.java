public class Flattening_of_LL {

    // Definition of special linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data) {
            val = data;
            next = null;
            child = null;
        }

        ListNode(int data, ListNode nextNode, ListNode childNode) {
            val = data;
            next = nextNode;
            child = childNode;
        }
    }

    // Merge two sorted linked lists using child pointers
    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.child = list1;
                curr = list1;
                list1 = list1.child;
            } else {
                curr.child = list2;
                curr = list2;
                list2 = list2.child;
            }
            curr.next = null;
        }

        if (list1 != null) {
            curr.child = list1;
        } else {
            curr.child = list2;
        }

        return dummy.child;
    }

    // Flatten the linked list
    public static ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mergedHead = flattenLinkedList(head.next);

        return merge(head, mergedHead);
    }

    // Print flattened linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }

    // Print original multi-level linked list
    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.val);

            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; i++) {
                    System.out.print("| ");
                }
            }

            head = head.next;
        }
    }

    // Driver code
    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        System.out.println("Original Linked List:");
        printOriginalLinkedList(head, 0);

        ListNode flattened = flattenLinkedList(head);

        System.out.print("\nFlattened Linked List: ");
        printLinkedList(flattened);
    }
}

/*
Approach:
1. Recursively flatten the right-side linked list.
2. Merge the current list with the flattened list.
3. Use child pointers to maintain sorted order.

Time Complexity: O(N * M)
Space Complexity: O(N) (recursion stack)
*/