class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()) freq[c]++;
        int ans = 0;
        boolean[] vis = new boolean[128];
        for(char c : s.toCharArray()) {
            if(vis[c]) continue;
            char temp;
            if(Character.isLetter(c)) temp = (char)('z'-(c-'a'));
            else temp = (char)('9'-(c-'0'));

            ans += Math.abs(freq[c] - freq[temp]);

            vis[c] = true;
            vis[temp] = true;
        }
        return ans;
    }
}