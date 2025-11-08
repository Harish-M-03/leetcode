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
    private void LeafNode(TreeNode node,ArrayList<Integer> arr){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            arr.add(node.val);
            return;
        }
        LeafNode(node.left,arr);
        LeafNode(node.right,arr);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        LeafNode(root1,arr1);
        LeafNode(root2,arr2);
        return arr1.equals(arr2);
    }
}