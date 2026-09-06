class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
       int[][] result=new int[intervals.length+1][2];
       int k=0;
       result[k]=intervals[0];
       for(int i=1;i<intervals.length;i++){
        int[] nums1=result[k];
        int[] nums2=intervals[i];
        if(nums1[1]<nums2[0]){
            result[++k]=nums2;
        }else{
            int n1=Math.min(nums1[0],nums2[0]);
            int n2=Math.max(nums1[1],nums2[1]);
            result[k]=new int[]{n1,n2};
        }
       }
       return Arrays.copyOf(result,k+1);
    }
}