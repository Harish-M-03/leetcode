import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // Convert to ArrayList (same as your logic)
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(nums));

        // Sort by numeric value using string comparison
        Collections.sort(arr, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            } else {
                return a.compareTo(b);
            }
        });

        // Reverse (to get descending order)
        Collections.reverse(arr);

        // Return k-th largest as string
        return arr.get(k - 1);
    }
}
