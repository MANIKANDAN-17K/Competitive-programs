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
        long maxPro = 0,total = 0;
        static final int mod = 1_000_000_007;
        private void dfsTot(TreeNode node){
            if(node == null) return;
            total += node.val;
            dfsTot(node.left);
            dfsTot(node.right);
        }
        private long dfs(TreeNode node){
            if(node == null) return 0;
            long left = dfs(node.left);
            long right = dfs(node.right);
            long sum = left + right + node.val;
            maxPro = Math.max(maxPro,sum * (total - sum));
            return sum;
        }
    public int maxProduct(TreeNode root) {
        dfsTot(root);
        dfs(root);
        return (int) (maxPro % mod);
    }
}
