class Solution {
    public String reverseOnlyLetters(String s) {
        // Step 1: Collect all letters (ignore non-letters)
        StringBuilder letters = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.append(ch);
            }
        }

        // Step 2: Reverse the collected letters
        String reversed = letters.reverse().toString();

        // Step 3: Rebuild the string with reversed letters in place
        StringBuilder result = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                result.append(reversed.charAt(j));
                j++;
            } else {
                result.append(ch); // Keep symbols/numbers/spaces as-is
            }
        }

        return result.toString();
    }
}
