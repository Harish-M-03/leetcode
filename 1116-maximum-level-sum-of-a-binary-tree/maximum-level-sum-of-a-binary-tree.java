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
    private void BFS(TreeNode root,ArrayList<ArrayList<Integer>> arr){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> ar=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                ar.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            arr.add(ar);
        }
    }
    public int maxLevelSum(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        BFS(root,arr);
        int maxi=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int num:arr.get(i)){
                sum+=num;
            }
            if(maxi<sum){
                maxi=sum;
                index=i+1;
            }
        }
        return index;
    }
}