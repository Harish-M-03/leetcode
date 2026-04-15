class Solution {
    public boolean circularArrayLoop(int[] nums) {
         int n = nums.length;

        boolean isValid = false;

        for (int start = 0; start < n; start++) {
            int i = start;
            HashSet<Integer> set = new HashSet<>();
            boolean forward = nums[start] > 0;

            while (true) {
                if ((nums[i] > 0) != forward) break;

                int idx = ((i + nums[i]) % n + n) % n;
                if (idx == i) break;

                if (set.contains(idx)) {
                    isValid = true;
                    break;
                } else {
                    set.add(idx);
                }

                i = idx;
            }

            if (isValid) break;
        }
        return isValid;
    }
}