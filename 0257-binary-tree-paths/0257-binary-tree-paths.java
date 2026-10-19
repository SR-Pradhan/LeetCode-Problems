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
    public void helper(TreeNode root, List<String> ans, StringBuilder sb) {
        if (root == null) {
            return;
        }

        // Add the current node to the path
        sb.append(root.val);

        // If leaf node, save the complete path
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }

        // Explore the right subtree
        if (root.right != null) {
            int length = sb.length();
            sb.append("->");
            helper(root.right, ans, sb);
            sb.setLength(length); // Backtrack
        }

        // Explore the left subtree
        if (root.left != null) {
            int length = sb.length();
            sb.append("->");
            helper(root.left, ans, sb);
            sb.setLength(length); // Backtrack
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(root, ans, sb);

        return ans;
    }
}
