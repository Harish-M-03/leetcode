/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {

    // BFS to collect all node values from a tree
    private void BFS(TreeNode node, List<Integer> list) {
        if (node == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr.val);

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> values = new ArrayList<>();

        // Collect all elements from both trees
        BFS(root1, values);
        BFS(root2, values);

        // Sort all collected values
        Collections.sort(values);

        return values;
    }
}
