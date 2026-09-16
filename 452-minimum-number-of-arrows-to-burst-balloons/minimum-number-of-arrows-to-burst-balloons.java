class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
       int[][] result=new int[points.length][2];
       int k=0;
       result[k]=points[0];
       for(int i=1;i<points.length;i++){
            int[] nums1=result[k];
            int[] nums2=points[i];
            if(nums1[1]<nums2[0]){
                result[++k]=nums2;
            }else{
                int n1=Math.max(nums1[0],nums2[0]);
                int n2=Math.min(nums1[1],nums2[1]);
                result[k]=new int[]{n1,n2};
            }
       }
       return k+1;
    }
}