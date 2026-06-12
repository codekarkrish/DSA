import java.util.HashMap;

public class Linked_List_Cycle {

    // Definition for singly linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to detect cycle using HashMap
    public static boolean hasCycle(ListNode head) {

        HashMap<ListNode, Integer> nodeMap = new HashMap<>();

        while (head != null) {

            if (nodeMap.containsKey(head)) {
                return true;
            }

            nodeMap.put(head, 1);
            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Connect nodes
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create cycle: 5 -> 3
        fifth.next = third;

        if (hasCycle(first)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");
        }
    }
}