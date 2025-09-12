class Solution {
    public boolean doesAliceWin(String s) {
        long vowelsCount = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int size = s.length();
        for(int i = 0; i < size; i++) {
            if(vowels.contains(s.charAt(i))) {
                vowelsCount++;
                break;
            }
        }
        return vowelsCount > 0;
    }
}