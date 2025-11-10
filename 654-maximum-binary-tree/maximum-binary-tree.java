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
    private TreeNode ConstructTree(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = maximum(arr, start, end);
        TreeNode node = new TreeNode(arr.get(mid));

        node.left = ConstructTree(arr, start, mid - 1);
        node.right = ConstructTree(arr, mid + 1, end);

        return node;
    }

    private int maximum(ArrayList<Integer> arr, int start, int end) {
        int maxi = Integer.MIN_VALUE;
        int index = -1;

        for (int i = start; i <= end; i++) {
            if (arr.get(i) > maxi) {
                maxi = arr.get(i);
                index = i;
            }
        }

        return index;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        return ConstructTree(arr, 0, arr.size() - 1);
    }
}
