class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            char cl=(char)((int)ch+32);
            char cu=(char)((int)ch-32);
            if(!stack.isEmpty()&&(cl==stack.peek()||cu==stack.peek())){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        String result="";
        for(char ch:stack){
            result+=ch;
        }
        return result;
    }
}