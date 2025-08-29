class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE; 
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true; // found nums[i] < nums[k] < nums[j]
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop(); // nums[k] candidate
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
