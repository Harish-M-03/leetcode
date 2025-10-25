class Solution {
    public int totalMoney(int n) {
        int total=0;
        int day=0;
        int start=1;
        if(n<=7){
            for(int j=1;j<=n;j++){
                total+=j;
            }
        }else{
            while(day<n){
                int curr=start;
                for(int j=0;j<7&&day<n;j++){
                    total+=curr;
                    curr++;
                    day++;
                }
                start++;
            }
        }
    return total;
    }
}