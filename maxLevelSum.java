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
    public int maxLevelSum(TreeNode root) {
        int maxV = Integer.MIN_VALUE;
        int ans = 0;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            level++;
            int n = q.size();
            int levelSum = 0;
            for(int i = n;i>0;--i){
                TreeNode node = q.poll();
                levelSum += node.val;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if(maxV < levelSum){
                maxV = levelSum;
                ans = level;
            }
        }
        return ans; 
    }
}
