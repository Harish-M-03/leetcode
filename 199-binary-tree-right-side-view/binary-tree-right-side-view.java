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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        BFS(root,arr);
        for(ArrayList<Integer> ar:arr){
            int n=ar.size();
            res.add(ar.get(n-1));
        }
        return res;
    }
}