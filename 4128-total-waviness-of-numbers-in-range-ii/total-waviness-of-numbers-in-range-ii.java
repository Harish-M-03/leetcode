class Solution {

    private String s;
    private long[][][][][][] memoCnt;
    private long[][][][][][] memoSum;
    private boolean[][][][][][] vis;

    private long[] dfs(int pos, int tight, int started,
                       int lenState, int prev2, int prev1) {

        if (pos == s.length()) {
            return new long[]{1L, 0L}; // {countNumbers, totalWaviness}
        }

        if (vis[pos][tight][started][lenState][prev2][prev1]) {
            return new long[]{
                memoCnt[pos][tight][started][lenState][prev2][prev1],
                memoSum[pos][tight][started][lenState][prev2][prev1]
            };
        }

        long count = 0;
        long sum = 0;

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                long[] child = dfs(pos + 1, ntight, 0, 0, 10, 10);
                count += child[0];
                sum += child[1];
            } else {

                if (started == 0) {
                    long[] child = dfs(pos + 1, ntight, 1, 1, 10, d);
                    count += child[0];
                    sum += child[1];
                }
                else if (lenState == 1) {
                    long[] child = dfs(pos + 1, ntight, 1, 2, prev1, d);
                    count += child[0];
                    sum += child[1];
                }
                else {

                    int extra = 0;

                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        extra = 1;
                    }

                    long[] child = dfs(pos + 1, ntight, 1, 2, prev1, d);

                    count += child[0];
                    sum += child[1] + child[0] * extra;
                }
            }
        }

        vis[pos][tight][started][lenState][prev2][prev1] = true;
        memoCnt[pos][tight][started][lenState][prev2][prev1] = count;
        memoSum[pos][tight][started][lenState][prev2][prev1] = sum;

        return new long[]{count, sum};
    }

    private long solve(long n) {
        if (n < 0) return 0;

        s = Long.toString(n);

        memoCnt = new long[s.length()][2][2][3][11][11];
        memoSum = new long[s.length()][2][2][3][11][11];
        vis = new boolean[s.length()][2][2][3][11][11];

        return dfs(0, 1, 0, 0, 10, 10)[1];
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}