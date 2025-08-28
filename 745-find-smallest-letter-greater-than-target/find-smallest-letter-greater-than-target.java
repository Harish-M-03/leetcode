class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int tar=(int)target;
        int left=0,right=letters.length-1;
        char ans=letters[0];
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=(int)letters[mid];
            if(res>tar){
                ans=letters[mid];
                right = mid - 1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}