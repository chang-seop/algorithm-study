package StudyFiles.GraphCircuit.DFS.P24479;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 정점의 수
    static int M; // 간선의 수
    static int R; // 시작 정점
    static boolean[] visited;
    static LinkedList<Integer>[] adjList; // 인접 리스트
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/DFS/P24479/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
        // 두 정점 사이에 여러 개의 간선이 있다
        // 입력으로 주어지는 간선은 양방향
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(adjList[i]); //오름차순으로 방문
        }

        dfsList(R);
        for (int i = 1; i <= N; i++)sb.append(answer[i]).append("\n");
        System.out.println(sb);
    }
    static void dfsList(int v) {
        //체크인
        visited[v] = true;
        answer[v] = ++idx;
        // 정점 인접리스트 순회
        // 목적지 인가?
        // 연결된 곳 순회하기
        for (int w : adjList[v]) {
            // 갈 수 있는가?
            if (!visited[w]) {
                // 간다
                dfsList(w);
            }
        }
        // 체크 아웃
    }
}
