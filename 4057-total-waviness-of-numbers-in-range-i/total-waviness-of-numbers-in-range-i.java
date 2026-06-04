class Solution {
    private int isPeak(int num){
        int peak=0;
        String str=Integer.toString(num);
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i)>str.charAt(i-1)&&str.charAt(i)>str.charAt(i+1)){
                peak++;
            }
        }
        return peak;
    }
    private int isValley(int num){
        int valley=0;
        String str=Integer.toString(num);
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i)<str.charAt(i-1)&&str.charAt(i)<str.charAt(i+1)){
                valley++;
            }
        }
        return valley;
    }   
    public int totalWaviness(int num1, int num2) {
        int waviness=0;
        for(int i=num1;i<=num2;i++){
            waviness+=isPeak(i);
            waviness+=isValley(i);
        }
        return waviness;
    }
}