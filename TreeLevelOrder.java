// The Challenge: Binary Tree Level Order Traversal
//
//Problem: Given a "Tree" of numbers, return the numbers grouped by their level (top to bottom, left to right).
//
//    Input: A tree where 3 is the root, 9 and 20 are its children, and 20 has children 15 and 7.
//
//    Goal: [[3], [9, 20], [15, 7]]
//magine you drop a stone in a pond.
//
//    The first "plop" is the Root (Level 0).
//
//    Then, a small circle ripple moves out to the Children (Level 1).
//
//    Then, a bigger circle ripple hits the Grandchildren (Level 2).
//
//The Logic: We use a Queue (a literal waiting line).
//
//    We put the Root in line.
//
//    When it's the Root's turn to leave the line, it must "invite" its children to join the back of the line.
//
//    We process the line level by level until nobody is left.
//For a Developer (Queue-Based BFS)
//
//In Java, we use java.util.Queue (specifically a LinkedList implementation) to manage the "waiting line." This is an O(n) operation because we visit every node exactly once.
//The Technical Strategy
//
//    Initialize: Add the root to a Queue.
//
//    Level Loop: While the queue is not empty:
//
//        Find the size of the queue (this tells you how many people are on the current level).
//
//        Create a sub-list for this level.
//
//    Processing: For each node in the current level:
//
//        Remove it from the queue (poll).
//
//        Add its value to the sub-list.
//
//        Add its left and right children to the queue for the next level.
import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeLevelOrder {
    public static void main(String[] args) {
        // Constructing the tree:
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order: " + levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // How many nodes on this level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add children to the queue for the NEXT level
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}

//FIFO (First-In, First-Out): This is the opposite of a Stack. By using a Queue, we ensure that we finish everyone on the "current floor" before we move to the "basement."
//
//Snapshot Logic: The line int levelSize = queue.size(); is the "secret sauce." It takes a snapshot of how many nodes belong to the current level so that even as we add children (the next level) to the queue, we don't accidentally process them too early.
//
//Non-Linear Thinking: This is our first leap away from arrays/strings into Graph Theory. Trees are just graphs without cycles.