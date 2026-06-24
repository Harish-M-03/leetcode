class Solution {
    public boolean consecutiveSetBits(int n) {
        StringBuilder str = new StringBuilder();
        int temp = n;

        while (temp != 0) {
            str.append(temp % 2);
            temp /= 2;
        }

        String s = str.reverse().toString();

        int pairs = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') {
                pairs++;
            }
        }

        return pairs == 1;
    }
}