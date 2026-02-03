class Solution {
    public int titleToNumber(String columnTitle) {
        int last=122;
        int res=0;
        for(char ch:columnTitle.toCharArray()){
            int num=ch-'A'+1;
            res=res*26+num;
        }
        return res;
    }
}