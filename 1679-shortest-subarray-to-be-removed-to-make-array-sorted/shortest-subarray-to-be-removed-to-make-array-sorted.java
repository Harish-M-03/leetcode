class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;
        int count = 0;

        // Step 1: count prefix violations
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If array already sorted
        if (left == n - 1) return 0;

        count = n - left - 1; // removing the suffix

        // Step 2: count suffix violations
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        count = Math.min(count, right); // removing the prefix

        // Step 3: Merge using count logic
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                count = Math.min(count, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}
