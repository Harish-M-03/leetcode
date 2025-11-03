class Solution {
    public int minCost(String colors, int[] neededTime) {
        int count=0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                if (neededTime[i - 1] < neededTime[i]) {
                    count += neededTime[i - 1];
                } else {
                    count += neededTime[i];
                    neededTime[i] = neededTime[i - 1]; 
                }
            }
        }
        return count;
    }
}