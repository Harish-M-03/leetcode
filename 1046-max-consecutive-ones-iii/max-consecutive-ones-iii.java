class Solution {
    //time : O(n), n =number of elements to loop through
    //space:O(1)

    public int longestOnes(int[] nums, int k) {

        // ij                       k = 1
        // 1  1  1  0  0  1  0      j expands

        // i           j            <- j cross k limit
        // 1  1  1  0  0  1  0      <- i activated to move

        //             ij
        // 1  1  1  0  0  1  0

        //             i     j      
        // 1  1  1  0  0  1  0

        //                i     j     <- j reached end
        // 1  1  1  0  0  1  0


        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;

        while(j < nums.length){
            if(nums[j] == 0) count++;
            
            while(count > k){
                max = Math.max(max, j - i);
                if(nums[i] == 0) count--;
                i++;
            }
            j++;
        }

        return Math.max(max, j - i);
    }
}