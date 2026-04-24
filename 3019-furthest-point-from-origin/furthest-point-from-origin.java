class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int horizontal=0,blank=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                horizontal--;
            }else if(moves.charAt(i)=='R'){
                horizontal++;
            }else{
                blank++;
            }
        }
        return Math.abs(horizontal)+blank;
    }
}