class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // arr[i] = {left, right, weight, originalIndex}
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        // next[i] = first interval that doesn't overlap with i
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int low = i + 1;
            int high = n;

            while (low < high) {

                int mid = low + (high - low) / 2;

                // Strictly greater because sharing boundary = overlap
                if (arr[mid][0] > arr[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = low;
        }

        // dp[i][k] = maximum weight starting from i
        // when we can still select k intervals
        long[][] dp = new long[n + 1][5];

        // Store selected original indices
        int[][][] result = new int[n + 1][5][];

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Don't select current interval
                long skip = dp[i + 1][k];
                int[] skipResult = result[i + 1][k];

                // Select current interval
                long take = arr[i][2] + dp[next[i]][k - 1];

                int[] takeResult;

                if (result[next[i]][k - 1] == null) {

                    takeResult = new int[]{arr[i][3]};

                } else {

                    int[] old = result[next[i]][k - 1];

                    takeResult = new int[old.length + 1];

                    takeResult[0] = arr[i][3];

                    for (int j = 0; j < old.length; j++) {
                        takeResult[j + 1] = old[j];
                    }

                    Arrays.sort(takeResult);
                }

                if (take > skip) {

                    dp[i][k] = take;
                    result[i][k] = takeResult;

                } else if (skip > take) {

                    dp[i][k] = skip;
                    result[i][k] = skipResult;

                } else {

                    // Same score -> lexicographically smaller
                    dp[i][k] = take;

                    result[i][k] =
                        lexicographicallySmaller(
                            takeResult,
                            skipResult
                        );
                }
            }
        }

        return result[0][4] == null
                ? new int[0]
                : result[0][4];
    }


    private int[] lexicographicallySmaller(int[] a, int[] b) {

        if (a == null)
            return b;

        if (b == null)
            return a;

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] < b[i])
                return a;

            if (a[i] > b[i])
                return b;
        }

        return a.length <= b.length ? a : b;
    }
}