class Solution {

    private void sumtoroot(TreeNode root, StringBuilder str, ArrayList<String> ar) {
        if (root == null) {
            return;
        }
        str.append(root.val);
        if (root.left == null && root.right == null) {
            ar.add(str.toString());
            return;
        }
        sumtoroot(root.left, new StringBuilder(str), ar);
        sumtoroot(root.right, new StringBuilder(str), ar);
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<String> ar = new ArrayList<>();
        sumtoroot(root, new StringBuilder(), ar);

        int total = 0;
        for (String st : ar) {
            int num = 0;
            for (char c : st.toCharArray()) {
                num = num * 10 + (c - '0');
            }
            total += num;
        }
        return total;
    }
}
