class Solution {

    public long maxHeight(long time, int t) {
        long low = 0, high = 100000;

        while (low <= high) {
            long mid = (low + high) / 2;

            long need = (long) t * mid * (mid + 1) / 2;

            if (need <= time) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long low = 0;
        long high = (long) 1e16;

        long ans = high;

        while (low <= high) {

            long mid = (low + high) / 2;

            long total = 0;

            for (int t : workerTimes) {

                total += maxHeight(mid, t);

                if (total >= mountainHeight) break;
            }

            if (total >= mountainHeight) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}