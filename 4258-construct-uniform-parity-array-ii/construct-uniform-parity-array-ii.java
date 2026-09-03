class Solution {
    public boolean uniformArray(int[] nums1) {
        int small=Integer.MAX_VALUE;
        for(int num:nums1){
            if(num%2!=0){
                small=Math.min(small,num);
            }
        }
        for(int num:nums1){
            if(num%2==0&&num<small&&small!=Integer.MAX_VALUE){
                return false;
            }
        }
        return true;
    }
}