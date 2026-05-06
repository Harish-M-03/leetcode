class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int mini=1;
        int maxi=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
            }
        }
        List<Integer> arr=new ArrayList<>();
        for(int i=1;i<=maxi;i++){
            if(!set.contains(i)){
                arr.add(i);
            }
        }
        return arr;
    }
}