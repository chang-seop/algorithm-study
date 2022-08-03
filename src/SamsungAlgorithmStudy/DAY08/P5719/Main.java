package SamsungAlgorithmStudy.DAY08.P5719;

import java.io.*;
import java.util.*;
public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final int MAXN = 500;
    static int[] dist;
    static int N, M, S, D;
    static int[][] adj; //adjacent matrix
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        adj = new int[MAXN][MAXN];
        dist = new int[MAXN];
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 || M == 0) return;
            for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) adj[i][j] = 0;
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            int u, v, p;
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                adj[u][v] = p;
            }
            dijkstra(S);
            removeShortest();
            dijkstra(S);
            if(dist[D] == INF) System.out.println(-1);
            else System.out.println(dist[D]);
        }
    }
    public static void dijkstra(int start) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.add(new Route(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Route cur = pq.poll();
            if(dist[cur.v] < cur.weight) continue;
            for(int i = 0; i < N; i++) {
                if(adj[cur.v][i] == 0) continue;
                int next = i;
                int w = cur.weight + adj[cur.v][i];
                if(dist[next] > w) {
                    dist[next] = w;
                    pq.add(new Route(next, w));
                }
            }
        }
    }
    public static void removeShortest() {
        Queue<Integer> q = new LinkedList<>();
        q.add(D);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < N; i++) {
                if(adj[i][cur] != 0 && dist[cur] == dist[i] + adj[i][cur]) {
                    adj[i][cur] = 0;
                    q.add(i);
                }
            }
        }
    }

}
class Route implements Comparable<Route>{
    int v;
    int weight;
    public Route(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
    @Override
    public int compareTo(Route o) {
        if(this.weight > o.weight) return 1;
        else if(this.weight < o.weight) return -1;
        else return 0;
    }
}