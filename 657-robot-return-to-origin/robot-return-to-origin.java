class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0, horizontal = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                vertical++;
            } else if (ch == 'D') {
                vertical--;
            } else if (ch == 'L') {
                horizontal--;
            } else if (ch == 'R') {
                horizontal++;
            }
        }

        return vertical == 0 && horizontal == 0;
    }
}