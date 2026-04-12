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
    private void LeafNodes(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            arr.add(root.val);
        }
        LeafNodes(root.left,arr);
        LeafNodes(root.right,arr);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        LeafNodes(root1,arr1);
        LeafNodes(root2,arr2);
        return arr1.equals(arr2);
    }
}