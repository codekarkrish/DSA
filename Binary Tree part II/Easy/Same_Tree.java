import java.util.*;;

public class Same_Tree {
     static class Node{
            int data ;
            Node left ;
            Node right;

            Node( int val){
                data = val ;
                left = null;
                right = null;
            }
        }
    public boolean isSame(Node p , Node q){
        if(p == null && q == null){
            return true;
        }
        if( p == null || q == null){
            return false ;
        }
        return ( p.data == q.data ) &&
        isSame(p.left, q.left) &&
        isSame(p.right , q.right);
    }
public static void main(String[] args) {
        // Creating the first binary tree (Node1)
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Creating the second binary tree (Node2)
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        // Creating an instance of the Solution class
        Same_Tree solution = new Same_Tree();

        // Check if the two binary trees are identical and output the result
        if (solution.isSame(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}


/*  
tc : O( N + M)

sc : O( H1 + H2)
*/