class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        int remain = 0;

        // Count how many `letter` remain in string
        for (char c : s.toCharArray()) {
            if (c == letter) remain++;
        }

        int need = repetition;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Try to remove previous characters if better lexicographically
            while (!st.isEmpty() &&
                   st.peek() > c &&
                   (st.size() - 1 + (n - i)) >= k && // enough characters left
                   (st.peek() != letter || remain > need)) {

                if (st.pop() == letter) {
                    need++;  // removing a required letter
                }
            }

            // Add character if stack has space
            if (st.size() < k) {
                if (c == letter) {
                    st.push(c);
                    need--;
                } else {
                    // Ensure enough space left for required letters
                    if (k - st.size() > need) {
                        st.push(c);
                    }
                }
            }

            if (c == letter) remain--;
        }

        // Build answer
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        return sb.toString();
    }
}
