class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> seen=new HashSet<>();
        int sum=0,left=0,maxsum=0;
        for(int right=0;right<nums.length;right++){
            while(seen.contains(nums[right])){
                seen.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            seen.add(nums[right]);
            sum+=nums[right];
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
}