class Solution {
    private boolean isPali(String str, int index) {
        StringBuilder st = new StringBuilder(str);
        st.deleteCharAt(index);
        int start = 0, end = st.length() - 1;
        while (start < end) {
            if (st.charAt(start) != st.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int mid = end / 2;

        while (start <= mid) {
            if (s.charAt(start) != s.charAt(end)) {
                // check removing one char from either side
                return isPali(s, start) || isPali(s, end);
            }
            start++;
            end--;
        }
        return true; // already palindrome
    }
}
