// We assume TreeNode is already defined elsewhere in your project
// class TreeNode { int val; TreeNode left; TreeNode right; ... }

public class TreeLogic {
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

        // Call our new DFS Logic
        int depth = maxDepth(root);
        System.out.println("The maximum depth of the tree is: " + depth);
    }

    /**
     * Logic: Depth-First Search (DFS)
     * Concept: Post-Order Traversal
     */
    public static int maxDepth(TreeNode root) {
        // BASE CASE: If the branch is empty, it has 0 height
        if (root == null) {
            return 0;
        }

        // RECURSIVE STEP: Go deep into left and right branches
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // COMBINE: Take the deeper path and add 1 for the current node
        return Math.max(left, right) + 1;
    }
}