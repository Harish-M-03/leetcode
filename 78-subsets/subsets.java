class Solution {
    private void subset(int[] nums,List<List<Integer>> res,List<Integer> curr,int idx,int size){
        if(idx==size){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        subset(nums,res,curr,idx+1,size);
        curr.remove(curr.size()-1);
        subset(nums,res,curr,idx+1,size);
    } 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        subset(nums,res,curr,0,nums.length);
        return res;
    }
}