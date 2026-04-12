class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            boolean destroyed=false;
            while(!stack.isEmpty()&&(stack.peek()>0&&asteroids[i]<0)){
                int top=stack.peek();
                if(Math.abs(top)<Math.abs(asteroids[i])){
                    stack.pop();
                }else if(Math.abs(top)==Math.abs(asteroids[i])){
                    stack.pop();
                    destroyed=true;
                    break;
                }else{
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(asteroids[i]);
            }
        }
        int[] arr=new int[stack.size()];
        int i=0;
        for(int num:stack){
            arr[i++]=num;
        }
        return arr;
    }
}