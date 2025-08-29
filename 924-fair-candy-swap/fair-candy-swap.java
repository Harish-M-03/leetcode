class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA=0,sumB=0;
        HashSet<Integer> setA=new HashSet<>();
        for(int num:aliceSizes){
            sumA+=num;
        }
        for(int num:bobSizes){
            sumB+=num;
        }
        int diff=(sumA-sumB)/2;
        for(int num:aliceSizes){
            setA.add(num);
        }
        for(int num:bobSizes){
            int x=num+diff;
            if(setA.contains(x)){
                return new int[]{x,num};
            }
        }
        return new int[]{};
    }
}