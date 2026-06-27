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
    List<List<Integer>> result=new ArrayList<>();
    private void paths(TreeNode root, int targetSum,List<Integer> ar,int sum){
        if(root==null){
            return;
        }
        sum+=root.val;
        ar.add(root.val);
        if(root.left==null&&root.right==null&&sum==targetSum){
            result.add(new ArrayList<>(ar));
        }
        paths(root.left,targetSum,ar,sum);
        paths(root.right,targetSum,ar,sum);
        ar.remove(ar.size() - 1); 
    } 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths(root,targetSum,new ArrayList<>(),0);
        return result;
    }
}