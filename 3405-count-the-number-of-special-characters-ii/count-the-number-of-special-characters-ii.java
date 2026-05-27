class Solution {
    public int numberOfSpecialChars(String word) {

        int count = 0;

        boolean[] upper = new boolean[26];
        boolean[] invalid = new boolean[26];
        boolean[] counted = new boolean[26];

        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z') {

                int idx = ch - 'a';

                if(upper[idx]) {
                    invalid[idx] = true;
                }

            } 
            else {

                int idx = ch - 'A';

                upper[idx] = true;
            }
        }

        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z') {

                int idx = ch - 'a';

                if(!invalid[idx] && upper[idx] && !counted[idx]) {
                    count++;
                    counted[idx] = true;
                }
            }
        }

        return count;
    }
}