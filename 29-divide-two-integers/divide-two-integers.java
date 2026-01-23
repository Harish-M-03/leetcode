class Solution {

    private boolean isGreat(long num1, long target) {
        return num1 <= target;
    } 

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Long> pow = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            long n = 1L << i;          
            long num = dvs * n;

            if (isGreat(num, dvd)) {
                arr.add(num);
                pow.add(n);
            } else {
                break;
            }
        }

        long quotient = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) <= dvd) {
                dvd -= arr.get(i);
                quotient += pow.get(i);
            }
        }

        return negative ? (int) -quotient : (int) quotient;
    }
}
