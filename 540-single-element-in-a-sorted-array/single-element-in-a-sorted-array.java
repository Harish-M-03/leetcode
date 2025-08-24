class Solution {
    private boolean isSingle(int[] arr, int mid) {
        boolean left = true;
        boolean right = true;

        if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
            right = false;
        }
        if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
            left = false;
        }

        return left && right;
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isSingle(nums, mid)) {
                ans = nums[mid];
                break;
            }

            if (mid % 2 == 0) {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return ans;
    }
}
