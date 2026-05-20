class Solution {

    private int commonInteger(int[] A, int[] B, int n) {

        int count = 0;

        for (int num = 1; num <= 50; num++) {

            boolean inA = false;
            boolean inB = false;

            for (int i = 0; i <= n; i++) {
                if (A[i] == num) {
                    inA = true;
                }

                if (B[i] == num) {
                    inB = true;
                }
            }

            if (inA && inB) {
                count++;
            }
        }

        return count;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = commonInteger(A, B, i);
        }

        return result;
    }
}