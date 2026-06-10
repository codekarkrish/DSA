public class Add_Two_Numbers_LinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        return dummy.next;
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

    // Function to create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        // Represents 342
        int[] num1 = {2, 4, 3};

        // Represents 465
        int[] num2 = {5, 6, 4};

        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        System.out.print("First Number  : ");
        printList(l1);

        System.out.print("Second Number : ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Result        : ");
        printList(result);
    }
}