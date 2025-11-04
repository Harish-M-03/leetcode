import java.util.*;

class Solution {
    private int sliding(int[] nums, int x){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }
        list.sort((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1];
            return b[0] - a[0];
        });
        int sum = 0;
        for (int i = 0; i < Math.min(x, list.size()); i++) {
            sum += list.get(i)[0] * list.get(i)[1];
        }

        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int[] window = Arrays.copyOfRange(nums, i, i + k);
            ans[i] = sliding(window, x);
        }

        return ans;
    }
}
