/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void helper(TreeNode root) {
        // Base case: if the node is null, stop recursion
        if (root == null) {
            return;
        }

        // Swap the left and right children of the current node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert the left subtree
        helper(root.left);

        // Invert the right subtree
        helper(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        // Invert the entire tree and return its root
        helper(root);
        return root;
    }
}
