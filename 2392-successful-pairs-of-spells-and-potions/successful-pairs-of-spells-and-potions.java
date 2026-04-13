import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = n - 1;
            int ans = n;

            while (left <= right) {
                int mid = (left + right) / 2;
                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            res[i] = n - ans;
        }

        return res;
    }
}