class Solution {
    public boolean checkIfPangram(String sentence) {
        sentence=sentence.toLowerCase();
        int[] freq=new int[26];
        for(char ch:sentence.toCharArray()){
            if(Character.isLetter(ch)){
                freq[ch-'a']++;
            }
        }
        boolean isPanagram=true;
        for(int num:freq){
            if(num==0){
                isPanagram=false;
                break;
            }
        }
        return isPanagram;
    }
}