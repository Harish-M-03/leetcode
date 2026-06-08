class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        boolean[] visited=new boolean[nums.length];
        int[] result=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                visited[i]=true;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==true){
                result[k++]=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                result[k++]=nums[i];
                visited[i]=true;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==false){
                result[k++]=nums[i];
            }
        }
        return result;
    }
}