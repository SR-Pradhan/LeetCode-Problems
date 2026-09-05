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
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // Check left and right children
                if (node.left != null) {

                    // x and y are siblings
                    if (node.left.val == x || node.left.val == y) {
                        if (node.right != null &&
                            (node.right.val == x || node.right.val == y)) {
                            return false;
                        }
                    }

                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                // Check current node
                if (node.val == x) {
                    foundX = true;
                }

                if (node.val == y) {
                    foundY = true;
                }
            }

            // Both found at the same level
            if (foundX && foundY) {
                return true;
            }

            // Only one found at this level
            if (foundX || foundY) {
                return false;
            }
        }

        return false;
    }
}