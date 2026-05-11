import java.util.*;

class Solution {

    private void sort(int[] nums, int[] result) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
    }

    public int thirdMax(int[] nums) {

        int[] result = new int[nums.length];

        sort(nums, result);

        int distinct = 1;

        for (int i = result.length - 2; i >= 0; i--) {

            if (result[i] != result[i + 1]) {
                distinct++;
            }

            if (distinct == 3) {
                return result[i];
            }
        }

        return result[result.length - 1];
    }
}