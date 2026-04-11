class Solution {
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public int maxVowels(String s, int k) {
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int maxi = count;

        // Sliding window
        for (int i = k; i < s.length(); i++) {
            // Add new character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // Remove old character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            maxi = Math.max(maxi, count);
        }

        return maxi;
    }
}