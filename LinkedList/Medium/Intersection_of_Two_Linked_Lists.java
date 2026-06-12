public class Intersection_of_Two_Linked_Lists {

    // Definition for singly linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to find intersection node
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        // Find length of first list
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        // Find length of second list
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        int diff = Math.abs(lenA - lenB);

        // Move pointer of longer list ahead
        if (lenA > lenB) {
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            while (diff-- > 0) {
                headB = headB.next;
            }
        }

        // Traverse both lists together
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    // Print linked list
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

        // Common part (intersection)
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        System.out.print("List A: ");
        printList(headA);

        System.out.print("List B: ");
        printList(headB);

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node Value: " + intersection.val);
        } else {
            System.out.println("No Intersection Found");
        }
    }
}