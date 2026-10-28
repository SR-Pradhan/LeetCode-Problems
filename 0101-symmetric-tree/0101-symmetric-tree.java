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
    public boolean helper(TreeNode left, TreeNode right) {
        // Both nodes are null, so they are symmetric
        if (left == null && right == null) {
            return true;
        }

        // Only one node is null, so they are not symmetric
        if (left == null || right == null) {
            return false;
        }

        // Values must match, and opposite subtrees must be symmetric
        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) &&
               helper(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }
}
