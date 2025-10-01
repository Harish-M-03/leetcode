class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank=numBottles;
        int empties=numBottles;
        int sum=0;
        while(empties>=numExchange){
            int newBottles=empties/numExchange;
            drank+=newBottles;
            empties=newBottles+(empties%numExchange);
        }
        return drank;
    }
}