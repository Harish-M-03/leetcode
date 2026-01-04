class Solution {

    private void dfs(int row, int col, int[][] image,
                     boolean[][] visited, int originalColor, int newColor) {

        // Boundary + validity checks
        if (row < 0 || col < 0 || 
            row >= image.length || col >= image[0].length ||
            visited[row][col] ||
            image[row][col] != originalColor) {
            return;
        }

        visited[row][col] = true;
        image[row][col] = newColor;

        // 4-direction DFS
        dfs(row - 1, col, image, visited, originalColor, newColor);
        dfs(row + 1, col, image, visited, originalColor, newColor);
        dfs(row, col - 1, image, visited, originalColor, newColor);
        dfs(row, col + 1, image, visited, originalColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // Optimization: if color is same, no change needed
        if (originalColor == color) {
            return image;
        }

        boolean[][] visited = new boolean[image.length][image[0].length];

        dfs(sr, sc, image, visited, originalColor, color);

        return image;
    }
}
