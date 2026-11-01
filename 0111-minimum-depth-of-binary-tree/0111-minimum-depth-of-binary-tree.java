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
    public int helper(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        if(leftDepth == 0 && rightDepth == 0) return 1;
        else if(leftDepth == 0) return 1 + rightDepth;
        else if(rightDepth == 0) return 1 + leftDepth;
        else return 1 + Math.min(leftDepth, rightDepth);
    }
    public int minDepth(TreeNode root) {
          return helper(root);
        
    }
}
