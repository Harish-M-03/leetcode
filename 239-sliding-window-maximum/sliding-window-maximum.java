class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        int left=0,index=0,n=nums.length;
        int[] result=new int[n-k+1];
        for(int right=0;right<n;right++){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[right]){
                deque.pollLast();
            }
            deque.offerLast(right);
            if(deque.peekFirst()<left){
                deque.removeFirst();
            }
            if(right-left+1==k){
                result[index++]=nums[deque.peekFirst()];
                left++;
            }
        }
        return result;
    }
}