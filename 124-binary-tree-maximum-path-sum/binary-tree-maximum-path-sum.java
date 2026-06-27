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
    int maxi=Integer.MIN_VALUE;
    private int maxsum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,maxsum(root.left));
        int right=Math.max(0,maxsum(root.right));
        int current=root.val+left+right;
        maxi=Math.max(maxi,current);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return maxi;
    }
}