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
    private void AddString(TreeNode root,List<String> arr,String str){
        if(root==null){
            return;
        }
        if(str.length()==0){
            str=""+root.val;
        }else{
            str=str+"->"+root.val;
        }
        if(root.left==null&&root.right==null){
            arr.add(str);
            return;
        }
        AddString(root.left,arr,str);
        AddString(root.right,arr,str);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr=new ArrayList<>();
        AddString(root,arr,"");
        return arr;
    }
}