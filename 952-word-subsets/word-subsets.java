class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {

        int[] maxFreq = new int[26];

        // Build max frequency array from words2
        for (String w : words2) {
            int[] freq = new int[26];
            for (char c : w.toCharArray()) {
                freq[c - 'a']++;
                maxFreq[c - 'a'] = Math.max(maxFreq[c - 'a'], freq[c - 'a']);
            }
        }

        List<String> result = new ArrayList<>();

        // Check each word in words1
        for (String word : words1) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result;
    }
}
