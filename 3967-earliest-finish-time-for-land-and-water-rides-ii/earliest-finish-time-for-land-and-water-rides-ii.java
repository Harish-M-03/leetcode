import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        // preprocess water rides
        int[][] water = new int[waterStartTime.length][2];

        for (int i = 0; i < waterStartTime.length; i++) {
            water[i][0] = waterStartTime[i];
            water[i][1] = waterDuration[i];
        }

        Arrays.sort(water, (a, b) -> a[0] - b[0]);

        int m = water.length;

        int[] prefixMinDuration = new int[m];
        int[] suffixMinFinish = new int[m];

        prefixMinDuration[0] = water[0][1];

        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] =
                Math.min(prefixMinDuration[i - 1], water[i][1]);
        }

        suffixMinFinish[m - 1] =
            water[m - 1][0] + water[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                suffixMinFinish[i + 1],
                water[i][0] + water[i][1]
            );
        }

        // land -> water
        for (int i = 0; i < landStartTime.length; i++) {

            int finish = landStartTime[i] + landDuration[i];

            int idx = upperBound(water, finish);

            if (idx >= 0) {
                ans = Math.min(ans,
                        finish + prefixMinDuration[idx]);
            }

            if (idx + 1 < m) {
                ans = Math.min(ans,
                        suffixMinFinish[idx + 1]);
            }
        }

        // preprocess land rides
        int[][] land = new int[landStartTime.length][2];

        for (int i = 0; i < landStartTime.length; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
        }

        Arrays.sort(land, (a, b) -> a[0] - b[0]);

        int n = land.length;

        prefixMinDuration = new int[n];
        suffixMinFinish = new int[n];

        prefixMinDuration[0] = land[0][1];

        for (int i = 1; i < n; i++) {
            prefixMinDuration[i] =
                Math.min(prefixMinDuration[i - 1], land[i][1]);
        }

        suffixMinFinish[n - 1] =
            land[n - 1][0] + land[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                suffixMinFinish[i + 1],
                land[i][0] + land[i][1]
            );
        }

        // water -> land
        for (int i = 0; i < waterStartTime.length; i++) {

            int finish = waterStartTime[i] + waterDuration[i];

            int idx = upperBound(land, finish);

            if (idx >= 0) {
                ans = Math.min(ans,
                        finish + prefixMinDuration[idx]);
            }

            if (idx + 1 < n) {
                ans = Math.min(ans,
                        suffixMinFinish[idx + 1]);
            }
        }

        return ans;
    }

    private int upperBound(int[][] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}