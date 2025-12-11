class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st1 = new Stack<>();   // waiting for 1st greater
        Stack<Integer> st2 = new Stack<>();   // waiting for 2nd greater
        Stack<Integer> temp = new Stack<>();  // helper stack

        for (int i = 0; i < n; i++) {

            // resolve second greater for elements in st2
            while (!st2.isEmpty() && nums[st2.peek()] < nums[i]) {
                ans[st2.pop()] = nums[i];
            }

            // move elements from st1 → temp (found 1st greater)
            while (!st1.isEmpty() && nums[st1.peek()] < nums[i]) {
                temp.push(st1.pop());
            }

            // move from temp → st2 (now waiting for 2nd greater)
            while (!temp.isEmpty()) {
                st2.push(temp.pop());
            }

            // push current index into st1
            st1.push(i);
        }

        return ans;
    }
}
