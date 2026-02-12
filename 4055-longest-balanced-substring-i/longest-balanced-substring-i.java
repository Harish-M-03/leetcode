class Solution {
    public int longestBalanced(String s) {

        int maxLen = 1;

        for(int i = 0; i < s.length(); i++){

            HashMap<Character,Integer> map = new HashMap<>();

            for(int j = i; j < s.length(); j++){

                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);

                if(isBalanced(map)){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isBalanced(HashMap<Character,Integer> map){
        int freq = -1;

        for(int value : map.values()){
            if(freq == -1) freq = value;
            else if(freq != value) return false;
        }

        return true;
    }
}