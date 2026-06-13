public class Copy_List_with_Random_Pointer {

    // Node class
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {

        public Node copyRandomList(Node head) {

            if (head == null)
                return null;

            Node temp = head;

            // Step 1: Insert copy nodes between original nodes
            while (temp != null) {
                Node copy = new Node(temp.val);
                copy.next = temp.next;
                temp.next = copy;
                temp = copy.next;
            }

            // Step 2: Connect random pointers
            temp = head;
            while (temp != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                }
                temp = temp.next.next;
            }

            // Step 3: Separate original and copied lists
            temp = head;
            Node dummy = new Node(-1);
            Node copyTail = dummy;

            while (temp != null) {
                Node copy = temp.next;

                copyTail.next = copy;
                copyTail = copy;

                temp.next = copy.next;
                temp = temp.next;
            }

            return dummy.next;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print("Node = " + head.val);

            if (head.random != null)
                System.out.print(", Random = " + head.random.val);
            else
                System.out.print(", Random = null");

            System.out.println();
            head = head.next;
        }
    }

    public static void main(String[] args) {

        // Create list: 7 -> 14 -> 21 -> 28
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Random pointers
        head.random = head.next.next;               // 7 -> 21
        head.next.random = head;                    // 14 -> 7
        head.next.next.random = head.next.next.next;// 21 -> 28
        head.next.next.next.random = head.next;     // 28 -> 14

        System.out.println("Original List:");
        printList(head);

        Solution obj = new Solution();
        Node clonedHead = obj.copyRandomList(head);

        System.out.println("\nCloned List:");
        printList(clonedHead);
    }
}

//Time Complexity: O(3N), where N is the number of nodes in the linked list. 
// The algorithm makes three traversals of the linked list, once to create copies
//  and insert them between original nodes, then to set the random pointers of the 
// copied nodes to their appropriate copied nodes and then to separate the copied and original nodes.

//Space Complexity : O(N), where N is the number of nodes in the linked list as the only 
// extra additional space allocated it to create the copied list without creating any other additional 
// data structures.