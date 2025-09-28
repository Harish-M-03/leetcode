import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // Step 1: sort ascending
        for (int i = nums.length - 1; i >= 2; i--) {  // Step 2: check largest sides
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];  // Step 3: perimeter
            }
        }
        return 0;  // Step 4: no valid triangle
    }
}
