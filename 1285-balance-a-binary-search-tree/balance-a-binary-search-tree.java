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
    private ArrayList<ArrayList<Integer>> BFS(TreeNode node,ArrayList<ArrayList<Integer>> arr){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            ArrayList<Integer> sample=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode root=queue.poll();
                sample.add(root.val);
                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!=null){
                    queue.offer(root.right);
                }
            }
            arr.add(sample);
        }
        return arr;
    }
    private TreeNode BalancedTree(ArrayList<Integer> arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=BalancedTree(arr,start,mid-1);
        root.right=BalancedTree(arr,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root){
        ArrayList<Integer> sample=new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        BFS(root,arr);
        for(ArrayList<Integer> s:arr){
            for(int num:s){
                sample.add(num);
            }
        }
        Collections.sort(sample);
        return BalancedTree(sample,0,sample.size()-1);
    }
}