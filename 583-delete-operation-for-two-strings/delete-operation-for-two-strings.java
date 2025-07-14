class Solution {
    private int lcs(String w1,String w2){
        int[][] dp=new int[w1.length()+1][w2.length()+1];
        for(int i=1;i<=w1.length();i++){
          for(int j=1;j<=w2.length();j++){
            if(w1.charAt(i-1)==w2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }  
        }
        return dp[w1.length()][w2.length()];
    } 
    public int minDistance(String word1, String word2) {
        int len=lcs(word1,word2);
        return word1.length()+word2.length()-2*len;
    }
}