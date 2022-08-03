package SamsungAlgorithmStudy.DAY08.P3176;

import java.util.*;
import java.io.*;

class Main {
    static int N, D, depth[], dp[][], min[][], max[][];
    static List<int[]> adj[];

    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        depth[root] = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i = 0; i < adj[curr].size(); i++) {
                int[] next = adj[curr].get(i);
                int nv = next[0];
                int w = next[1];
                if(depth[nv] > 0) continue;
                dp[0][nv] = curr;
                max[0][nv] = min[0][nv] = w;
                depth[nv] = depth[curr] + 1;
                q.add(nv);
            }
        }
    }
    static int[] lca(int u, int v) {
        int min_ = Integer.MAX_VALUE, max_ = Integer.MIN_VALUE;
        if(depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[v] - depth[u];
        for(int i = 0; i <= D; i++) {
            if(((1 << i) & diff) > 0) {
                min_ = Math.min(min_, min[i][v]);
                max_ = Math.max(max_, max[i][v]);
                v = dp[i][v];
            }
        }
        if(u != v) {
            for(int i = D-1; i >= 0; i--) {
                if(dp[i][u] != dp[i][v]) {
                    min_ = Math.min(min_, Math.min(min[i][u], min[i][v]));
                    max_ = Math.max(max_, Math.max(max[i][u], max[i][v]));
                    u = dp[i][u];
                    v = dp[i][v];
                }
            }
            min_ = Math.min(min_, Math.min(min[0][u], min[0][v]));
            max_ = Math.max(max_, Math.max(max[0][u], max[0][v]));
        }
        return new int[] {min_, max_};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for(; (1 << D) < N; D++);
        depth = new int[N+1];
        dp = new int[D][N+1];
        min = new int[D][N+1];
        max = new int[D][N+1];
        adj = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }
        //tree 생성
        bfs(1);
        //sparse table 생성
        for(int j = 1; j < D; j++) {
            for(int i = 1; i <= N; i++) {
                dp[j][i] = dp[j-1][dp[j-1][i]];
                min[j][i] = Math.min(min[j-1][i], min[j-1][dp[j-1][i]]);
                max[j][i] = Math.max(max[j-1][i], max[j-1][dp[j-1][i]]);
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int res[] = lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bw.write(res[0] + " " + res[1] + "\n");
        }
        bw.close();
    }
}