class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty()&&prices[i]<=prices[stack.peek()]){
                int num=prices[stack.peek()]-prices[i];
                prices[stack.pop()]=num;
            }
            stack.push(i);
        }
        return prices;
    }
}