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
    private void pathsum(TreeNode root,int target,int sum,ArrayList<Integer> ar){
        if(root==null){
            return;
        }
        sum+=root.val;
        ar.add(root.val);
        if(root.left==null&&root.right==null&&target==sum){
            result.add(new ArrayList<>(ar));
        }
        pathsum(root.left,target,sum,ar);
        pathsum(root.right,target,sum,ar);
        ar.remove(ar.size()-1); 
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathsum(root,targetSum,0,new ArrayList<>());
        return result;
    }
}