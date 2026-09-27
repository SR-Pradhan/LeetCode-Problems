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
import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stk.isEmpty()) {

            // Go to the leftmost node
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }

            // Process the node
            curr = stk.pop();
            ans.add(curr.val);

            // Move to the right subtree
            curr = curr.right;
        }

        return ans;
    }
}