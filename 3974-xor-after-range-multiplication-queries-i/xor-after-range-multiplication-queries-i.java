class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        for(int i=0;i<queries.length;i++){
            int[] mat=queries[i];
            for(int j=mat[0];j<=mat[1];j+=mat[2]){
                long val = (long) nums[j] * mat[3];
                nums[j] = (int) (val % MOD);
            }
        }
        int num=0;
        for(int n:nums){
            num=num^n;
        }
        return num;
    }
}