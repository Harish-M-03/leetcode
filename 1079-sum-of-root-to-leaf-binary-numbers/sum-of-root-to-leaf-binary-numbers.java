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
    private void sumtoleaf(TreeNode root,StringBuilder str,ArrayList<String> ar){
        if(root==null){
            return;
        }
        str.append(Integer.toString(root.val));
        if(root.left==null&&root.right==null){
            ar.add(str.toString());
        }
        sumtoleaf(root.left,new StringBuilder(str),ar);
        sumtoleaf(root.right,new StringBuilder(str),ar);
    }
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> ar=new ArrayList<>();
        sumtoleaf(root,new StringBuilder(),ar);
        int total=0;
        for(String str:ar){
            int num=Integer.parseInt(str,2);
            total+=num;
        }
        return total;
    }
}