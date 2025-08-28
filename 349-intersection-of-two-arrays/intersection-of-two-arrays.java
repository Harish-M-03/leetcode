class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int maxlen=Math.max(nums1.length,nums2.length);
        ArrayList<Integer> arr=new ArrayList<>();
        int i=0,k=0;
        while(i<nums1.length){
            int ele1=nums1[i];
            int j=0;
            while(j<nums2.length){
                int ele2=nums2[j];
                if(ele1==ele2&&!arr.contains(ele2)){
                    arr.add(ele2);
                }
                j++;
            }
            i++;
        }
        int[] intersect=new int[arr.size()];
        for(int num:arr){
            intersect[k]=num;
            k++;
        }
        return intersect;
    }
}