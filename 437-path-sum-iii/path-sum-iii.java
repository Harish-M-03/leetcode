class Solution {
    int count = 0;

    private void pathSum(TreeNode root, long sum, int target){
        if(root == null){
            return;
        }

        sum += root.val;

        if(sum == target){
            count++;
        }

        pathSum(root.left, sum, target);
        pathSum(root.right, sum, target);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        // Start path from current node
        pathSum(root, 0, targetSum);

        // Try every node as new starting point
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }
}