class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum=0,k=cost.length-1,count=0;
        while(k>=0){
            count++;
            if(count%3!=0){
                sum+=cost[k];
            }
            k--;
        }
        return sum;
    }
}