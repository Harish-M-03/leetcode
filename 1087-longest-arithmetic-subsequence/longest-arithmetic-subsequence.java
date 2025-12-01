import java.util.HashMap;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        
        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        
        int ans = 2; // at least two numbers form an arithmetic subsequence when n>=2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diffLong = (long)nums[i] - (long)nums[j]; // avoid int overflow
                if (diffLong < Integer.MIN_VALUE || diffLong > Integer.MAX_VALUE) {
                    // extremely unlikely with typical constraints, skip or handle specially
                    continue;
                }
                int diff = (int) diffLong;
                
                int lenJ = dp[j].getOrDefault(diff, 1); // length counted as 1 for single element baseline
                int newLen = lenJ + 1; // extend sequence ending at j to i
                int existing = dp[i].getOrDefault(diff, 0);
                if (newLen > existing) {
                    dp[i].put(diff, newLen);
                    if (newLen > ans) ans = newLen;
                }
            }
        }
        return ans;
    }
}
