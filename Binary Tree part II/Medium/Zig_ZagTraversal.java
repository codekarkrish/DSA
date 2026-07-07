import java.util.*;

public class Zig_ZagTraversal {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    // Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Store final answer
        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return result;

        // Queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Add root node
        q.offer(root);

        // true = left to right
        // false = right to left
        boolean leftToRight = true;

        // Traverse level by level
        while (!q.isEmpty()) {

            // Number of nodes in current level
            int size = q.size();

            // Store current level values
            Integer[] level = new Integer[size];

            // Process current level
            for (int i = 0; i < size; i++) {

                // Remove front node
                TreeNode node = q.poll();

                // Decide position of current value
                int index = leftToRight ? i : size - 1 - i;

                // Store value
                level[index] = node.val;

                // Add left child
                if (node.left != null)
                    q.offer(node.left);

                // Add right child
                if (node.right != null)
                    q.offer(node.right);
            }

            // Add current level to answer
            result.add(Arrays.asList(level));

            // Change direction
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \     \
            4   5     6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Zig_ZagTraversal obj = new Zig_ZagTraversal();

        List<List<Integer>> ans = obj.zigzagLevelOrder(root);

        System.out.println(ans);
    }
}

/*
Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.

Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree, the last level could at most hold N/2 nodes hence the space complexity of the queue is proportional to O(N). The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.
*/