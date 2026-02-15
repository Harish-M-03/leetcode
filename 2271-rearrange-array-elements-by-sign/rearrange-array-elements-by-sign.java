class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int num:nums){
            if(num>0){
                pos.add(num);
            }else{
                neg.add(num);
            }
        }
        int i=0,j=0;
        while(i<pos.size()&&j<neg.size()){
            int n1=pos.get(i);
            int n2=neg.get(j);
            res.add(n1);
            res.add(n2);
            i++;
            j++;
        }
        while(i<pos.size()){
            int n1=pos.get(i);
            res.add(n1);
            i++;
        }
        while(j<neg.size()){
            int n2=neg.get(i);
            res.add(n2);
            j++;
        }
        int[] result=new int[res.size()];
        for(int k=0;k<res.size();k++){
            result[k]=res.get(k);
        }
        return result;
    }
}