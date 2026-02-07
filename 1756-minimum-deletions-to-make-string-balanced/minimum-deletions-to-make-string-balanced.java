class Solution {
    public int minimumDeletions(String s) {
        int deletions=0,bCount=0;
        for(char ch:s.toCharArray()){
            if(ch=='b'){
                bCount++;
            }else{
            deletions=Math.min(deletions+1,bCount);
            }
        }
        return deletions;
    }
}