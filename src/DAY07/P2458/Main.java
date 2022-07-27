package DAY07.P2458;
import java.io.*;
import java.util.*;

//그래프 이론 or 플로이드 위성
public class Main {
    static int N, M, inCnt[], outCnt[];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> adj[];
    static boolean visited[];

    static int dfs(int curr) {
        int outCnt = 0;
        for (int next : adj[curr]) {
            if (visited[next]) {
                continue;
            }
            inCnt[next]++;
            visited[next] = true;
            outCnt += dfs(next);
        }
        return outCnt + 1;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY07/P2458/input.txt"));
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        adj = new ArrayList[N + 1];

        inCnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        outCnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            outCnt[i] = dfs(i) - 1;
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if ((inCnt[i] + outCnt[i]) == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}