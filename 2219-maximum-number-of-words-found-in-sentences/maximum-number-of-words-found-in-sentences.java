class Solution {
    private int numberofwords(String sentence){
        String[] str=sentence.split(" ");
        return str.length;
    }
    public int mostWordsFound(String[] sentences) {
        int maxi=Integer.MIN_VALUE;
        for(String str:sentences){
            int num=numberofwords(str);
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }
}