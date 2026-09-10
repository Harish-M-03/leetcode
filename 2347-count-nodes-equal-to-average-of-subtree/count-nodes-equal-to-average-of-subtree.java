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
    private void preorder(ArrayList<Integer> ar,TreeNode root){
        if(root==null){
            return;
        }
        ar.add(root.val);
        preorder(ar,root.left);
        preorder(ar,root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        int count=0;
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<TreeNode> arr=new ArrayList<>(); 
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            arr.add(node);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        for(TreeNode node:arr){
            ArrayList<Integer> ar=new ArrayList<>();
            preorder(ar,node);
            int rnode=ar.get(0);
            int sum=0;
            for(int num:ar){
                sum+=num;
            }
            if(Math.round(sum/ar.size())==rnode){
                count++;
            }
        }
        return count;
    }
}