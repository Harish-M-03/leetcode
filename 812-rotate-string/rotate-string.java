class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int n = s.length();

        for (int start = 0; start < n; start++) {
            if (goal.charAt(start) == s.charAt(0)) {
                boolean match = true;

                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) != goal.charAt((start + i) % n)) {
                        match = false;
                        break;
                    }
                }

                if (match) return true;
            }
        }

        return false;
    }
}