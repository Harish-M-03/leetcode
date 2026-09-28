class Solution {
    public int maxDepth(String s) {
        int maxi=0;
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty()&&ch==')'){
                maxi=Math.max(maxi,stack.size());
                stack.pop();
            }else if(ch=='('){
                stack.push(ch);
            }
        }
        return maxi;
    }
}