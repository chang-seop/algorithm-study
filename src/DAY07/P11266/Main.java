package DAY07.P11266;

import java.io.*;
import java.util.*;

// 단절점, DFS 신장 트리
public class Main {
    static int order[];
    static boolean isCut[];
    static int cnt;
    static ArrayList<Integer> adj[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        order = new int[N+1];
        isCut = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        for(int i = 1; i <= N; i++) {
            if(order[i] == 0) {
                dfs(i, true);
            }
        }
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            ans += isCut[i] ? 1 : 0;
        }
        sb.append(ans + "\n");
        for(int i = 1; i <= N; i++) {
            if(isCut[i]) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    private static int dfs(int cur, boolean isRoot) {
        order[cur] = ++cnt;
        int ret = cnt;
        int child = 0;
        for(int next : adj[cur]) {
            if(order[next] == 0) {
                child++;
                int low = dfs(next, false);
                if(!isRoot && low >= order[cur]) {
                    isCut[cur] = true;
                }
                ret = Math.min(ret, low);
            } else {
                ret = Math.min(ret, order[next]);
            }
        }
        if(isRoot && child > 1) {
            isCut[cur] = true;
        }
        return ret;
    }
}