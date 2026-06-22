class Solution {
    public int maxNumberOfBalloons(String text) {
        String str="balloon";
        int[] freq=new int[26];
        for(char ch:text.toCharArray()){
            freq[ch-'a']++;
        }
        int count=0;
        while(true){
            boolean isValid=true;
            int cnt=0;
            for(char ch:str.toCharArray()){
                if(freq[ch-'a']>=1){
                    freq[ch-'a']--;
                }else{
                    isValid=false;
                    break;
                }
            }
            if(!isValid){
                break;
            }else{
                count+=1;
            }
        }
        return count;
    }
}