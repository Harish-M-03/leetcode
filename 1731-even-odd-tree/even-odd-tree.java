class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int val = node.val;

                // Parity check 
                if (level % 2 == 0) {
                    // Even level → values must be ODD and INCREASING
                    if (val % 2 == 0 || val <= prev) return false;
                } else {
                    // Odd level → values must be EVEN and DECREASING
                    if (val % 2 != 0 || val >= prev) return false;
                }

                prev = val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            level++;
        }
        return true;
    }
}
