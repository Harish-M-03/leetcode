class Solution {
    private void Subsequence(int[] nums,int index,int size,List<List<Integer>> arr,List<Integer> cur){
        if(index==size){
            arr.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        Subsequence(nums,index+1,size,arr,cur);
        cur.remove(cur.size()-1);
        Subsequence(nums,index+1,size,arr,cur);
    }
    private boolean isvalid(List<Integer> ar,int n){
        int sum=0;
        for(int num:ar){
            sum+=num;
        }
        return sum==n;
    } 
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums=new int[9];
        for(int i=0;i<9;i++){
            nums[i]=i+1;
        }
        List<List<Integer>> arr=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Subsequence(nums,0,nums.length,arr,new ArrayList<>());
        for(List<Integer> ar:arr){
            if(ar.size()==k&&isvalid(ar,n)){
                res.add(ar);
            }
        }
        return res;
    }
}