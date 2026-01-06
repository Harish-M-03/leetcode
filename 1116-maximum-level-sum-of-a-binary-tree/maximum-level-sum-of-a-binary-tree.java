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
    private void levelorder(TreeNode root,ArrayList<ArrayList<Integer>> arr){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> ar=new ArrayList<>();
            int size=queue.size();
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
        levelorder(root,arr);
        int level=1,maxi=Integer.MIN_VALUE,res=0;
        for(ArrayList<Integer> ar:arr){
            int sum=0;
            for(int num:ar){
                sum+=num;
            }
            if(maxi<sum){
                maxi=sum;
                res=level;
            }
            level++;
        }
        return res;
    }
}