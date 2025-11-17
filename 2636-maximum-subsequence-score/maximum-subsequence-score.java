class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // pair each (nums2[i], nums1[i])
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }

        // sort by nums2 descending
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {

            // add current nums1
            sum += pair[i][1];
            minHeap.add(pair[i][1]);

            // keep only k largest nums1 values
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // when we have exactly k elements
            if (minHeap.size() == k) {
                result = Math.max(result, sum * pair[i][0]);
            }
        }
        return result;
    }
}
