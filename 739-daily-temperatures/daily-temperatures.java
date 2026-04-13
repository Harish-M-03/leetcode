class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> helperstack=new Stack<>();
        int n=temperatures.length;
        int[] result=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!helperstack.isEmpty()&& temperatures[i]>=temperatures[helperstack.peek()]){
                helperstack.pop();
                }
            if(!helperstack.isEmpty()){
                result[i]=helperstack.peek()-i;
                }
            helperstack.push(i);
            }
        return result;
    }
}