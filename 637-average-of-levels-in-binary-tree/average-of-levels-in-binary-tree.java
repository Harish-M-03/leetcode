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
    private ArrayList<ArrayList<Integer>> averageList(TreeNode root,ArrayList<ArrayList<Integer>> arr1){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                arr.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            arr1.add(arr);
        }
        return arr1; 
    }
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
        averageList(root,arr1);
        List<Double> res=new ArrayList<>();
        for(ArrayList<Integer> arr:arr1){
            int size=arr.size();
            long total=0;
            for(int num:arr){
                total+=num;
            }
            double avg=(double)total/size;
            res.add(avg);
        }
        return res;
    }
}