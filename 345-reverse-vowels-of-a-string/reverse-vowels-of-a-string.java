class Solution {
    public String reverseVowels(String s) {
        String vowels="AEIOUaeiou";
        ArrayList<Integer> index=new ArrayList<>();
        ArrayList<Character> vowel=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i))!=-1){
                index.add(i);
                vowel.add(s.charAt(i));
            }
        }
        Collections.reverse(vowel);
        StringBuilder str=new StringBuilder(s);
        for(int i=0;i<index.size();i++){
            str.setCharAt(index.get(i),vowel.get(i));
        }
        return str.toString();
    }
}