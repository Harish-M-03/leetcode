class Solution {
    private int countOnes(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num == 1) {
                count++;
            }
        }
        return count;
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = -1;
        int rowIndex = -1;

        for (int i = 0; i < mat.length; i++) {
            int ones = countOnes(mat[i]);
            if (ones > maxOnes) {
                maxOnes = ones;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxOnes};
    }
}
