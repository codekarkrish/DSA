class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseList {

    // Function to reverse the linked list
    static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node front = curr.next; // store next node
            curr.next = prev;       // reverse link
            prev = curr;            // move prev forward
            curr = front;           // move curr forward
        }

        return prev; // new head
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        printList(head);

        head = reverseLinkedList(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}