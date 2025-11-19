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
    private void LevelOrder(ArrayList<ArrayList<Integer>> arr,TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> res=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                res.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            arr.add(res);
        }
    }
    public int maxLevelSum(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        LevelOrder(arr,root);
        int count=0,maxi=Integer.MIN_VALUE;
        int index=-1;
        for(ArrayList<Integer> ar:arr){
            int sum=0;
            count++;
            for(int num:ar){
                sum+=num;
            }
            if(maxi<sum){
                maxi=sum;
                index=count;
            }
        }
        return index;
    }
}