class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, computers, visit);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int node, int[][] computers, boolean[] visit) {
        visit[node] = true;
        for (int next = 0; next < computers[node].length; next++) {
            if (computers[node][next] == 1 && !visit[next]) {
                dfs(next, computers, visit);
            }
        }
    }
}