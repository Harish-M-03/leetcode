class Solution {
    public int findFinalValue(int[] nums, int original) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums){
            arr.add(num);
        }
        while(arr.contains(original)){
            original=original*2;
        }
        return original;
    }
}