class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;

        for(char c = 'a'; c <= 'z'; c++){
            int left = -1, right = -1;

            // Find first and last occurrence of character c
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == c){
                    if(left == -1) left = i;
                    right = i;
                }
            }

            // If character does not appear twice, skip
            if(right - left < 2) continue;

            // Count distinct middle characters
            HashSet<Character> set = new HashSet<>();
            for(int i = left + 1; i < right; i++){
                set.add(s.charAt(i));
            }

            result += set.size();
        }

        return result;
    }
}
