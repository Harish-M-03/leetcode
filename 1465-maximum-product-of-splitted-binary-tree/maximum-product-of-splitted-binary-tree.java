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
    long total=0;
    long max_prod=Integer.MIN_VALUE;
    static final int MOD = 1_000_000_007;
    private void dfstotal(TreeNode root){
        if(root==null){
            return;
        }
        total+=root.val;
        dfstotal(root.left);
        dfstotal(root.right);
    }
    private long dfssum(TreeNode root){
        if(root==null){
            return 0;
        }
        long left=dfssum(root.left);
        long right=dfssum(root.right);
        long subsum=left+right+root.val;
        max_prod=Math.max(max_prod,subsum*(total-subsum));
        return subsum;
    }
    public int maxProduct(TreeNode root) {
        dfstotal(root);
        dfssum(root);
        return (int)(max_prod % MOD);
    }
}