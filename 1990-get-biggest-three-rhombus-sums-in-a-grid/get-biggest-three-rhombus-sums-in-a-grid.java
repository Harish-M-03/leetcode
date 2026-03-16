import java.util.*;

class Solution {

    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // size = 0 (single cell rhombus)
                set.add(grid[i][j]);

                // try bigger rhombus
                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {

                    int sum = 0;

                    int x = i;
                    int y = j;

                    // top → right
                    for (int t = 0; t < k; t++) {
                        sum += grid[x - k + t][y + t];
                    }

                    // right → bottom
                    for (int t = 0; t < k; t++) {
                        sum += grid[x + t][y + k - t];
                    }

                    // bottom → left
                    for (int t = 0; t < k; t++) {
                        sum += grid[x + k - t][y - t];
                    }

                    // left → top
                    for (int t = 0; t < k; t++) {
                        sum += grid[x - t][y - k + t];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = set.pollLast();
        }

        return ans;
    }
}