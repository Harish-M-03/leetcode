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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null; // tree’s empty, nothing to see here
        if (root.val == val) return root; // jackpot, found it
        if (val < root.val) 
            return searchBST(root.left, val); // head left, smaller vibes
        else 
            return searchBST(root.right, val); // head right, bigger vibes
    }
}