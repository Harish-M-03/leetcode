class Solution {
    public boolean hasSameDigits(String s) {
        // reduce until length is exactly 2 (or less)
        while (s.length() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int num1 = s.charAt(i - 1) - '0';
                int num2 = s.charAt(i) - '0';
                int mod = (num1 + num2) % 10;
                sb.append((char) ('0' + mod)); // append digit as character (preserves leading zeros)
            }
            s = sb.toString();
        }

        // if it reduces to a single digit, it's not two equal digits
        if (s.length() < 2) return false;

        return s.charAt(0) == s.charAt(1);
    }
}
