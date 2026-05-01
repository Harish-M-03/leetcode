class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[temperatures.length];
        int n=temperatures.length;
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?0:Math.abs(i-stack.peek());
            stack.push(i);
        }
        return result;
    }
}