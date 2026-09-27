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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> trees = new ArrayList<>();

        // No nodes in this range
        if (start > end) {
            trees.add(null);
            return trees;
        }

        // Try every value as the root
        for (int i = start; i <= end; i++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = generate(start, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = generate(i + 1, end);

            // Combine every left subtree with every right subtree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    trees.add(root);
                }
            }
        }

        return trees;
    }
}