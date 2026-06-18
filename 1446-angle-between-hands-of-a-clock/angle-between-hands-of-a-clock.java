class Solution {
    public double angleClock(int hour, int minutes) {
        double result=30*(hour%12)+(0.5*minutes);
        int min=6*minutes;
        double res=Math.abs(result-min);
        return Math.min(res,360-res);
    }
}