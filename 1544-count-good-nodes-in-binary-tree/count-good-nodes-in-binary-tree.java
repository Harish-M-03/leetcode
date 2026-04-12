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
    int count=0;
    private void CountGreater(TreeNode root,int maxi){
        if(root==null){
            return;
        }
        if(maxi<=root.val){
            maxi=root.val;
            count++;
        }
        CountGreater(root.left,maxi);
        CountGreater(root.right,maxi);
    }
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        CountGreater(root,Integer.MIN_VALUE);
        return count;
    }
}