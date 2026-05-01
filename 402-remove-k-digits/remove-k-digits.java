class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(char ch:num.toCharArray()){
            while(!stack.isEmpty()&&k>0&&ch<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty()&&k>0){
            stack.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        for(char ch:stack){
            res.append(ch);
        }
        while(res.length() > 1 && res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }
        return res.length()==0?"0":res.toString();
    }
}