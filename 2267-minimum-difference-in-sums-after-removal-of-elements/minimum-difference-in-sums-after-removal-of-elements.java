class Solution {
    public long minimumDifference(int[] nums) {
        int n=nums.length/3;
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> right=new PriorityQueue<>();
        long[] minleft=new long[3*n];
        long leftSum=0;
        long rightSum=0;
        for(int i=0;i<n;i++){
            leftSum+=nums[i];
            left.add(nums[i]);
        }
        minleft[n-1]=leftSum;
        for(int i=n;i<2*n;i++){
            leftSum+=nums[i];
            left.add(nums[i]);
            leftSum-=left.poll();
            minleft[i]=leftSum;
        }
        for(int i=3*n-1;i>=2*n;i--){
            rightSum+=nums[i];
            right.add(nums[i]);
        }
        long res = minleft[2 * n - 1] - rightSum;
        
        for (int i = 2 * n - 1; i >= n; i--) {
            rightSum += nums[i];
            right.add(nums[i]);
            rightSum -= right.poll();
            res = Math.min(res, minleft[i - 1] - rightSum);
        }
        
        return res;
    }
}