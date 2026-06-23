class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?0:Math.abs(i-stack.peek());
            stack.push(i);
        }
        return result;
    }
}