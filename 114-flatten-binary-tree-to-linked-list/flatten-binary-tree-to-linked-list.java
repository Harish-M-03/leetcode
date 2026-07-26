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
    private void preorder(TreeNode root,ArrayList<TreeNode> ar){
        if(root==null){
            return;
        }
        ar.add(root);
        preorder(root.left,ar);
        preorder(root.right,ar);
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<TreeNode> ar=new ArrayList<>();
        preorder(root,ar);
        for(int i=0;i<ar.size()-1;i++){
            ar.get(i).left=null;
            ar.get(i).right=ar.get(i+1);
        }
        ar.get(ar.size()-1).left=null;
        ar.get(ar.size()-1).right=null;
    }
}