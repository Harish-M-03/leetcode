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
    private ArrayList<ArrayList<Integer>> LargestLevel(TreeNode root,ArrayList<ArrayList<Integer>> res){
        if (root == null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> s=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                s.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(s);
        }
        return res;
    }
    private int maximum(ArrayList<Integer> arr){
        int maxi=Integer.MIN_VALUE;
        for(int num:arr){
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> s=new ArrayList<>();
        LargestLevel(root,res);
        for(ArrayList<Integer> sample:res){
            int num=maximum(sample);
            s.add(num);
        }
        return s;
    }
}