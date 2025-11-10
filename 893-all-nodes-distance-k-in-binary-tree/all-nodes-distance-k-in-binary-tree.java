/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {

    // Helper: Collect nodes that are 'k' distance downwards from given node
    private void KNodes(TreeNode root, ArrayList<Integer> arr, int k) {
        if (root == null) return;
        if (k == 0) {
            arr.add(root.val);
            return;
        }
        KNodes(root.left, arr, k - 1);
        KNodes(root.right, arr, k - 1);
    }

    // Helper: Find distance from current node to target and collect nodes at distance k
    private int targetNode(TreeNode root, TreeNode target, int k, ArrayList<Integer> arr) {
        if (root == null) return -1;

        // Found the target node
        if (root == target) {
            KNodes(root, arr, k);  // collect k-distance nodes below target
            return 0;
        }

        // Search in left subtree
        int left = targetNode(root.left, target, k, arr);
        if (left != -1) {
            // Target found in left subtree at distance 'left'
            if (left + 1 == k)
                arr.add(root.val); // Current node is k distance away
            else
                KNodes(root.right, arr, k - left - 2); // Go to right subtree for remaining distance
            return left + 1;
        }

        // Search in right subtree
        int right = targetNode(root.right, target, k, arr);
        if (right != -1) {
            if (right + 1 == k)
                arr.add(root.val);
            else
                KNodes(root.left, arr, k - right - 2);
            return right + 1;
        }

        // Target not found in this subtree
        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        targetNode(root, target, k, arr);
        return arr;
    }
}
