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
    private TreeNode constructBinaryTree(ArrayList<Integer> ar,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(ar.get(mid));
        root.left=constructBinaryTree(ar,start,mid-1);
        root.right=constructBinaryTree(ar,mid+1,end);
        return root;
    }
    private void inorder(TreeNode root,ArrayList<Integer> ar1){
        if(root==null){
            return;
        }
        inorder(root.left,ar1);
        ar1.add(root.val);
        inorder(root.right,ar1);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        ArrayList<Integer> ar=new ArrayList<>();
        inorder(root,ar);
        ar.remove(Integer.valueOf(key));
        TreeNode result=constructBinaryTree(ar,0,ar.size()-1);
        return result;
    }
}