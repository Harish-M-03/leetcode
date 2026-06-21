class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt=0;
        int sum=0;
        for(int num:costs){
            if(num+sum<=coins){
                sum+=num;
                cnt++;
            }
        }
        return cnt;
    }
}