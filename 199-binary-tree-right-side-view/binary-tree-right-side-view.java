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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
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
        for(ArrayList<Integer> ar:arr){
            result.add(ar.get(ar.size()-1));
        }
        return result;
    }
}