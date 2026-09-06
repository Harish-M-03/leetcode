class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++){
            result[i]=intervals[i];
        }
        result[intervals.length]=newInterval;
        Arrays.sort(result,(a,b)->Integer.compare(a[0],b[0]));
        int[][] newarr=new int[result.length+1][2];
        int k=0;
        newarr[k]=result[0];
        for(int i=1;i<result.length;i++){
            int[] nums1=newarr[k];
            int[] nums2=result[i];
            if(nums1[1]<nums2[0]){
                newarr[++k]=nums2;
            }else{
                int n1=Math.min(nums1[0],nums2[0]);
                int n2=Math.max(nums1[1],nums2[1]);
                newarr[k]=new int[]{n1,n2};
            }
        }
        return Arrays.copyOf(newarr,k+1);
    }
}