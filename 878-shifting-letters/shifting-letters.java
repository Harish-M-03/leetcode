class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        long totalShift = 0;

        // ✅ we must go from right → left (suffix sum)
        for (int i = n - 1; i >= 0; i--) {
            totalShift += shifts[i];
            int shift = (int)(totalShift % 26);

            char ch = s.charAt(i);
            int r = ch - 'a' + shift;
            char c = (char)((r % 26) + 'a');

            // ✅ prepend to keep order
            res.insert(0, c);
        }
        return res.toString();
    }
}
