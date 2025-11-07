class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> res=new ArrayList<>();
        for(String str:words){
            String st=str;
            boolean found=false;
            for(String s:words){
                if(s.indexOf(st)!=-1&&!s.equals(st)){
                    found=true;
                    break;
                }
            }
            if(found){
                res.add(st);
            }
        }
        return res;
    }
}