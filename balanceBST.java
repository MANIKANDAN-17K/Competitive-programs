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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root,inorder);
        return createBalancedBST(inorder,0,inorder.size() - 1);
    }
    private void inorderTraversal(TreeNode root,List<Integer> inorder){
        if(root == null) return;
        inorderTraversal(root.left,inorder);
        inorder.add(root.val);
        inorderTraversal(root.right,inorder);
    }
    private TreeNode createBalancedBST(List<Integer> inorder,int s,int e){
        if(s>e) return null;
        int m = s + (e -s)/2;
        TreeNode ls = createBalancedBST(inorder,s,m-1);
        TreeNode rs = createBalancedBST(inorder,m+1,e);
        TreeNode n = new TreeNode(inorder.get(m),ls,rs);
        return n;
    }
}
