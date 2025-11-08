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
    private ArrayList<ArrayList<Integer>> sample(TreeNode node,ArrayList<ArrayList<Integer>> arr){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);;
        while(!queue.isEmpty()){
        ArrayList<Integer> arr1=new ArrayList<>();
        int size=queue.size();
        for(int i=0;i<size;i++){
            TreeNode root=queue.poll();
            arr1.add(root.val);
            if(root.left!=null){
                queue.offer(root.left);
            }
            if(root.right!=null){
                queue.offer(root.right);
            }
        }
        arr.add(arr1);
        }
        return arr;
    }
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        sample(root,arr);
        ArrayList<Integer> res=arr.get(arr.size()-1);
        return res.get(0);
    }
}