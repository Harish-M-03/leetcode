class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<String> set = new HashSet<>();

        // Store all prefixes of arr1 numbers
        for (int num : arr1) {

            String s = Integer.toString(num);
            String prefix = "";

            for (char ch : s.toCharArray()) {

                prefix += ch;
                set.add(prefix);
            }
        }

        int maxi = 0;

        // Check prefixes in arr2
        for (int num : arr2) {

            String s = Integer.toString(num);
            String prefix = "";

            for (char ch : s.toCharArray()) {

                prefix += ch;

                if (set.contains(prefix)) {
                    maxi = Math.max(maxi, prefix.length());
                }
            }
        }

        return maxi;
    }
}