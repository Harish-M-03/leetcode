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
    private int length(TreeNode root) {
    if (root == null) return 0;

    if (root.left == null) 
        return 1 + length(root.right);

    if (root.right == null)
        return 1 + length(root.left);

    return 1 + Math.min(length(root.left), length(root.right));
}
    public int minDepth(TreeNode root) {
        int i=0;
        return length(root);
    }
}