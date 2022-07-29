package DAY09.P2098;

import java.io.*;
import java.util.*;
public class Main {
    private static final int INF = 16000001; //TSP의 최대값보다 더 큰 값.
    static int N;
    static int[][] adj;
    static int allVisited;
    private static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        allVisited = (1 << N) - 1;
        adj = new int[N][N];
        dp = new int[16][allVisited];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        //0번 정점에서 시작해서 모든 정점 방문 후 다시 0번 정점으로 돌아오는 최소 비용
        //이 때 TSP의 해가 존재하면, 시작정점은 0이 아닌 다른 정점으로 해도 무조건 최적해임이 보장된다. (사이클이기 때문)
        System.out.println(dfs(0, 1));
    }

    //dp[cur][visit] : cur정점에서 visit(bitmask) 만큼 정점을 방문한 상태일 때,
    //                 나머지 정점 모두 방문 후 다시 0번 정점으로 돌아가는 최소비용
    public static int dfs(int cur, int visit) {
        if (visit == allVisited) return adj[cur][0] == 0 ? INF : adj[cur][0];
        if (dp[cur][visit] != -1) return dp[cur][visit];

        dp[cur][visit] = INF;
        for(int i = 0; i < N; i++) {
            int next = 1 << i;
            if(adj[cur][i] != 0 && ((visit & next) == 0)) {
                dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, (visit|next)) + adj[cur][i]);
            }
        }
        return dp[cur][visit];
    }

}