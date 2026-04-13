class Solution {
    private TreeNode Search(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }

        if (target < root.val) {
            return Search(root.left, target);
        } else {
            return Search(root.right, target);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return Search(root, val);
    }
}