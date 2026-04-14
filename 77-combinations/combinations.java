class Solution {
    private void Subsequence(int[] nums,int index,int size,List<Integer> cur,List<List<Integer>> arr){
        if(index==size){
            arr.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        Subsequence(nums,index+1,size,cur,arr);
        cur.remove(cur.size()-1);
        Subsequence(nums,index+1,size,cur,arr);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> arr=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        Subsequence(nums,0,n,new ArrayList<>(),arr);
        for(List<Integer> ar:arr){
            if(ar.size()==k){
                res.add(ar);
            }
        }
        return res;
    }
}