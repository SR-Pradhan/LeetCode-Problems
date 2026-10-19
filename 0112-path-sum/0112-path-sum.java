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
    public boolean helper(TreeNode root, int targetSum, int sum) {

        // If the node is null, no valid path exists through it
        if (root == null) {
            return false;
        }

        // Add the current node's value to the path sum
        sum += root.val;

        // Check the sum only when a leaf node is reached
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        // Check whether the left subtree contains a valid path
        boolean left = helper(root.left, targetSum, sum);

        // Check whether the right subtree contains a valid path
        boolean right = helper(root.right, targetSum, sum);

        // Return true if either subtree has a valid root-to-leaf path
        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Start with a path sum of zero
        return helper(root, targetSum, 0);
    }
}
