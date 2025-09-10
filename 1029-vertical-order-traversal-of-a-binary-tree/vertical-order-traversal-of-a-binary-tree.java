import java.util.*;

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
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // column index → list of [row, value]
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>(); 
        // queue holds {node, col, row}
        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] obj = queue.poll();
            TreeNode node = (TreeNode) obj[0];
            int col = (int) obj[1];
            int row = (int) obj[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            if (node.left != null) {
                queue.offer(new Object[]{node.left, col - 1, row + 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, col + 1, row + 1});
            }
        }

        // build final result
        List<List<Integer>> result = new ArrayList<>();
        for (int col : map.keySet()) {
            List<int[]> nodes = map.get(col);
            // sort: first by row, then by value
            Collections.sort(nodes, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> colVals = new ArrayList<>();
            for (int[] pair : nodes) {
                colVals.add(pair[1]);
            }
            result.add(colVals);
        }
        return result;
    }
}
