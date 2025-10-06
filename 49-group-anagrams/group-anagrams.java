import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> arr = new ArrayList<>();
        boolean[] visited = new boolean[strs.length]; // To track grouped words

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue; // Skip if already grouped

            List<String> sample = new ArrayList<>();
            sample.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    sample.add(strs[j]);
                    visited[j] = true;
                }
            }

            arr.add(sample);
        }

        return arr;
    }

    // Helper method to check if two strings are anagrams
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();

        // Count characters for s1
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        // Subtract counts for s2
        for (char c : s2.toCharArray()) {
            if (!map1.containsKey(c)) return false;
            map1.put(c, map1.get(c) - 1);
            if (map1.get(c) == 0) map1.remove(c);
        }

        return map1.isEmpty();
    }
}
