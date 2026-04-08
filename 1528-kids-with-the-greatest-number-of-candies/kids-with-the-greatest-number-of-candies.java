class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi=Integer.MIN_VALUE;
        for(int num:candies){
            if(maxi<num){
                maxi=num;
            }
        }
        List<Boolean> arr=new ArrayList<>();
        for(int num:candies){
            if(num+extraCandies>=maxi){
                arr.add(true);
            }else{
                arr.add(false);
            }
        }
        return arr;
    }
}