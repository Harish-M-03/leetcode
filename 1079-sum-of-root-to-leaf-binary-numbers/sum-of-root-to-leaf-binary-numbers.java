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
    private void SumtoLeaf(String str,TreeNode node,ArrayList<String> arr){
        if(node==null){
            return;
        }
        str=str+node.val;
        if(node.left==null&&node.right==null){
            arr.add(str);
        }
        SumtoLeaf(str,node.left,arr);
        SumtoLeaf(str,node.right,arr);
    }
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> arr=new ArrayList<>();
        SumtoLeaf("",root,arr);
        int sum=0;
        for(String st:arr){
            int num=Integer.parseInt(st,2);
            sum+=num;
        }
        return sum;
    }
}