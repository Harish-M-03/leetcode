class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
      String str="";
      for(String st:words){
        int sum=0;
        for(char ch:st.toCharArray()){
            int n=ch-'a';
            sum+=weights[n];
        }
        int idx=sum%26;
        char ch=(char)(122-idx);
        str+=ch;
      }
      return str;
    }
}