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
    private void BFS(TreeNode root,List<List<Integer>> arr){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ar=new ArrayList<>();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> arr=new ArrayList<>();
        BFS(root,arr);
        for(int i=0;i<arr.size();i++){
            if(i%2!=0){
                List<Integer> r=new ArrayList<>();
                for(int j=arr.get(i).size()-1;j>=0;j--){
                    r.add(arr.get(i).get(j));
                }
                arr.set(i,r);
            }
        }
        return arr;
    }
}