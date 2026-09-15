class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> increase=new ArrayDeque<>();
        Deque<Integer> decrease=new ArrayDeque<>();
        int maxlen=0,left=0;
        for(int i=0;i<nums.length;i++){
            while(!increase.isEmpty()&&nums[increase.peekLast()]<nums[i]){
                increase.pollLast();
            }
            while(!decrease.isEmpty()&&nums[decrease.peekLast()]>nums[i]){
                decrease.pollLast();
            }
            increase.offerLast(i);
            decrease.offerLast(i);
            while(Math.abs(nums[decrease.peekFirst()]-nums[increase.peekFirst()])>limit){
                if(increase.peekFirst()==left){
                    increase.pollFirst();
                }
                 if(decrease.peekFirst()==left){
                    decrease.pollFirst();
                }
                left++;
            }
            maxlen=Math.max(maxlen,i-left+1);
        }
        return maxlen;
    }
}