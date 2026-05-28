class Solution {

    static final long N = (long) -4e18;

    static class B {
        int n;
        long[] b;

        B(int n) {
            this.n = n;
            b = new long[n + 2];
            Arrays.fill(b, N);
        }

        void u(int i, long v) {
            for (; i <= n; i += i & -i)
                b[i] = Math.max(b[i], v);
        }

        long q(int i) {
            long r = N;
            for (; i > 0; i -= i & -i)
                r = Math.max(r, b[i]);
            return r;
        }
    }

    public long maxAlternatingSum(int[] a, int k) {
        int s = a.length;
        int m = Arrays.stream(a).max().getAsInt();
        
        long[] u = new long[s];
        long[] d = new long[s];
        
        B x = new B(m + 2);
        B y = new B(m + 2);
        long r = 0;

        for (int i = 0; i < s; i++) {
            if (i - k >= 0) {
                int j = i - k;
                int v = a[j];
                x.u(v, Math.max(d[j], (long) v));
                y.u((int) (m - v + 1), Math.max(u[j], (long) v));
            }

            int v = a[i];
            u[i] = d[i] = v;

            long p = x.q(v - 1);
            if (p != N)
                u[i] = p + v;

            long q = y.q((int) (m - v));
            if (q != N)
                d[i] = q + v;

            r = Math.max(r, Math.max(u[i], d[i]));
        }

        return r;
    }
}