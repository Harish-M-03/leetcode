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
    List<List<Integer>> arr=new ArrayList<>();
    private void pathsum(TreeNode root,int sum,int target,ArrayList<Integer> ar){
        if(root==null){
            return;
        }
        sum+=root.val;
        ar.add(root.val);
        if(root.left==null&&root.right==null&&target==sum){
            arr.add(new ArrayList<>(ar));
        }
        pathsum(root.left,sum,target,ar);
        pathsum(root.right,sum,target,ar);
        ar.remove(ar.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return arr;
        }
        pathsum(root,0,targetSum,new ArrayList<>());
        return arr;
    }
}