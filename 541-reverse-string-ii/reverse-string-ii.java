class Solution {
    public String reverseStr(String s, int k) {
        char [] char_s = s.toCharArray();
        int start=0;
        for( int i = 0; i < char_s.length; i+= 2 * k){
            start =i;
            int end= Math.min(i+k-1,char_s.length-1);
            reverse(start,end,char_s);
        }
        return String.valueOf(char_s);
    }
    public void reverse(int start,int end,char [] char_s){
        while(start<end){
            char temp= char_s[start];
            char_s[start]= char_s[end];
            char_s[end]= temp;
            start++;
            end--;
        }
    }
}