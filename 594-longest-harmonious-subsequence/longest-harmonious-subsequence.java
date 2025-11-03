class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        int best = 0;
        for (int k : freq.keySet()) {
            if (freq.containsKey(k + 1)) {
                best = Math.max(best, freq.get(k) + freq.get(k + 1));
            }
        }
        return best;
    }
}
