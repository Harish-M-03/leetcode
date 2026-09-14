class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] rec1X=new int[]{rec1[0],rec1[2]};
        int[] rec1Y=new int[]{rec1[1],rec1[3]};
        int[] rec2X=new int[]{rec2[0],rec2[2]};
        int[] rec2Y=new int[]{rec2[1],rec2[3]};
        if(rec1X[1] <= rec2X[0] ||
    rec2X[1] <= rec1X[0] ||
    rec1Y[1] <= rec2Y[0] ||
    rec2Y[1] <= rec1Y[0]){
            return false;
        }
        return true;
    }
}