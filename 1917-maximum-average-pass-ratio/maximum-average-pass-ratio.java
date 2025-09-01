import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0]) // sort by gain descending
        );

        // Initialize heap with [gain, pass, total]
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = getGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++; total++; // add one guaranteed pass student
            double gain = getGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Compute final average
        double sum = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            int pass = (int) c[1], total = (int) c[2];
            sum += (double) pass / total;
        }
        return sum / classes.length;
    }

    // helper to compute gain of adding one more pass student
    private double getGain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
}
