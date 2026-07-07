import java.util.*;
public class LCA_in_BT {
    static class TreeNode{
        int data ;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            data = val ;
            left = null;
            right = null;
        }
    }
    public TreeNode lca(TreeNode root , TreeNode p , TreeNode q){
        if( root == null || root == p || root == q){
            return root ;
        }
        TreeNode left = lca( root.left , p, q);
        TreeNode right = lca( root.right,p,q);

        if( left == null) return right ;
        else if( right == null) return left ;
        return root ;
    }
}

/*
TC: O(N)  Visit each node once
SC: O(H)  Recursive stack, H = height of tree
*/
