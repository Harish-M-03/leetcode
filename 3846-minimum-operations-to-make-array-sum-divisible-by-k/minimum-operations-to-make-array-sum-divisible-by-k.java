class Solution {
    public int minOperations(int[] nums, int k) {
        long sm = 0;
        for (int x : nums) sm += x;
        long r = sm % k;
        return (int) r;
    }
}