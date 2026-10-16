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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return res;

        q.offer(root);

        while(!q.isEmpty()){

            int n = q.size();
            ArrayList<Integer> ans = new ArrayList<>();

            while(n-- > 0){
                TreeNode T = q.poll();
                ans.add(T.val);

                if(T.left != null){
                    q.offer(T.left);
                }

                if(T.right != null){
                    q.offer(T.right);
                }
            }
            res.add(ans);
        }
        return res;
    }
}