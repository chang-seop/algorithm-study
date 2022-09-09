package WorkingTable.P1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList; //인접 리스트
    static boolean[] visited;
    static int[] answer;
    static int idx = 0;
    static int N, M, V; // N 정점의 개수, M 간선의 개수
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        // DFS
        dfs(V);
        for(int i = 1; i <= N; i++) sb.append(answer[i]).append(" ");
        System.out.println(sb);

        //BFS
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        idx = 0;

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            //큐에서 가져오기
            int v = queue.poll();
            answer[v] = ++idx;
            //목적지 인가?
            //연결된 곳 순회
            for(int i : adjList[v]) {

                //갈 수 있는가?
                if(!visited[i]) {
                    //체크인
                    visited[i] = true;
                    //큐에 넣기
                    queue.add(i);
                }
            }
        }

        for(int i = 1; i <= N; i++) sb.append(answer[i]).append(" ");
        System.out.print(sb);
    }
    static void dfs(int index)  {
        // 체크인
        visited[index] = true;
        answer[index] = ++idx;
        // 목적지 인가?
        // 연결된 곳 순회하기
        for(int i : adjList[index]) {
            // 갈 수 있는가?
            if(!visited[i]) {
                // 간다
                dfs(i);
            }
        }
        // 체크아웃
    }
}
