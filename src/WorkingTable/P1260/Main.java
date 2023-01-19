package WorkingTable.P1260;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visitedDfs, visitedBfs;
    static int N, M, V; // 정점의 개수 N, 간선의 개수 M, 시작할 정점의 번호 V
    static ArrayList<Integer>[] adjList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Integer a = Integer.parseInt(st.nextToken());
            Integer b = Integer.parseInt(st.nextToken());

            // 입력으로 주어지는 간선은 양방향
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문 하기 위해 오름차순 정렬
        for (int i = 1; i <= N; i++) Collections.sort(adjList[i]);

        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        dfs(V, 0);
        sb.append("\n");
        bfs();

        // 결과

        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Integer> point = new LinkedList<>();
        point.add(V); // 시작 정점 추가
        // 시작 정점 체크인
        visitedBfs[V] = true;
        sb.append(V).append(" ");

        //BFS
        while(!point.isEmpty()) {
            Integer polled = point.poll();

            for(Integer go : adjList[polled]) {
                if(!visitedBfs[go]) {
                    visitedBfs[go] = true;
                    sb.append(go).append(" ");
                    point.add(go);
                }
            }
        }
    }

    private static void dfs(int index, int count) {
        visitedDfs[index] = true;
        sb.append(index).append(" ");

        for(Integer go : adjList[index]) {
            if(!visitedDfs[go]) {
                dfs(go, count + 1);
            }
        }
    }

}