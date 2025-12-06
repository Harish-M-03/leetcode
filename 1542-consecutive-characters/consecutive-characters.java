class Solution {
    public int maxPower(String s) {
        int count = 1;   // current run length
        int maxi = 1;    // maximum run length

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;                 // continue run
            } else {
                maxi = Math.max(maxi, count);    
                count = 1;               // reset for new char
            }
        }

        // Check last run
        maxi = Math.max(maxi, count);

        return maxi;
    }
}
