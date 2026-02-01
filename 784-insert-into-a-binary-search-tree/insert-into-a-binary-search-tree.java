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
    private TreeNode constructBinaryTree(ArrayList<Integer> arr,int left,int right) {
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=constructBinaryTree(arr,left,mid-1);
        root.right=constructBinaryTree(arr,mid+1,right);
        return root;
    }
    private void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    } 
    public TreeNode insertIntoBST(TreeNode root, int val) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        arr.add(val);
        Collections.sort(arr);
        root=constructBinaryTree(arr,0,arr.size()-1);
        return root;
    }
}