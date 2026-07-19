class Solution {

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] state) {

        if (state[node] == 1) {
            return false;
        }

        if (state[node] == 2) {
            return true;
        }

        state[node] = 1;

        for (int next : adj.get(node)) {
            if (!dfs(next, adj, state)) {
                return false;
            }
        }

        state[node] = 2;

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] state = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, state)) {
                return false;
            }
        }

        return true;
    }
}