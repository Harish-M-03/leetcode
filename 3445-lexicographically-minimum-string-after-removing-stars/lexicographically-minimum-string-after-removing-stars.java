import java.util.*;

class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );
        
        boolean[] removed = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == '*') {
                int[] top = pq.poll();  
                removed[top[1]] = true; 
                removed[i] = true;      
            } else {
                pq.offer(new int[]{ch, i});
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}