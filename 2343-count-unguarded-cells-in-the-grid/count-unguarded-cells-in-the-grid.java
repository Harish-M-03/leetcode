import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] result = new int[m][n]; // 0=empty, 1=guard, 2=wall, 3=guarded

        // Mark walls
        for (int[] w : walls) {
            result[w[0]][w[1]] = 2;
        }

        // Mark guards
        for (int[] g : guards) {
            result[g[0]][g[1]] = 1;
        }

        // Optional: keep sets (you had these)
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int[] i : guards) {
            row.add(i[0]);
            col.add(i[1]);
        }

        // Mark each guard's visible cells (not full cross product)
        for (int[] g : guards) {
            int r = g[0], c = g[1];

            // left
            for (int j = c - 1; j >= 0; j--) {
                if (result[r][j] == 1 || result[r][j] == 2) break;
                result[r][j] = 3;
            }

            // right
            for (int j = c + 1; j < n; j++) {
                if (result[r][j] == 1 || result[r][j] == 2) break;
                result[r][j] = 3;
            }

            // up
            for (int i = r - 1; i >= 0; i--) {
                if (result[i][c] == 1 || result[i][c] == 2) break;
                result[i][c] = 3;
            }

            // down
            for (int i = r + 1; i < m; i++) {
                if (result[i][c] == 1 || result[i][c] == 2) break;
                result[i][c] = 3;
            }
        }

        // Count unguarded cells (still 0)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) count++;
            }
        }

        return count;
    }
}
