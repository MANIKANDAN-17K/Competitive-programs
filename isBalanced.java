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
    public boolean isBalanced(TreeNode root) {
        int res[] = dfs(root);
        return res[0] == 1;
    }
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{1,0};
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);

        boolean isBool = left[0] == 1 && right[0] == 1 && Math.abs(right[1] - left[1]) <= 1;
        return new int[]{isBool ? 1 : 0,1+Math.max(left[1],right[1])};
    }
}
