class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> arr=new ArrayList<>();
        ArrayList<Integer> ar1=new ArrayList<>();
        ArrayList<Integer> ar2=new ArrayList<>();
        ArrayList<Integer> res1=new ArrayList<>();
        ArrayList<Integer> res2=new ArrayList<>();
        for(int num:nums1){
            ar1.add(num);
        }
        for(int num:nums2){
            ar2.add(num);
        }
        for(int num:nums1){
            if(!res1.contains(num)&&!ar2.contains(num)){
                res1.add(num);
            }
        }
        for(int num:nums2){
            if(!res2.contains(num)&&!ar1.contains(num)){
                res2.add(num);
            }
        }
        arr.add(res1);
        arr.add(res2);
        return arr;
    }
}