class Solution {
    public int mirrorDistance(int n) {
        StringBuilder str=new StringBuilder(Integer.toString(n));
        str=str.reverse();
        while(str.length()>1&&str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }
        int res=Integer.parseInt(str.toString());
        return Math.abs(n-res);
    }
}