class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int[] result=new int[nums2.length];
       int[] res=new int[nums1.length];
       Stack<Integer> stack=new Stack<>();
       for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums2[i]>=nums2[stack.peek()]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?-1:nums2[stack.peek()];
            stack.push(i);
       }
       for(int i=0;i<nums1.length;i++){
            int maxi=-1;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    maxi=result[j];
                    break;
                }
            }
            res[i]=maxi;
       }
       return res;
    }
}