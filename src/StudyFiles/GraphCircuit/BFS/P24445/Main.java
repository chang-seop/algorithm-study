package StudyFiles.GraphCircuit.BFS.P24445;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R; //정점, 간선, 시작정점
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int[] answer;
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P24445/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        //정점 초기화
        for (int i = 0; i <= N; i++) adjList[i] = new LinkedList<>();

        //간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            adjList[m1].add(m2);
            adjList[m2].add(m1); // 무방향 그래프
        }
        // 인접 정점은 내림차순으로 접근 해야 함으로 정렬
        for (int i = 1; i <= N; i++) {
            adjList[i].sort(Collections.reverseOrder());
        }

        //큐에 넣기
        queue.add(R);
        visited[R] = true;

        while(!queue.isEmpty()) {
            //큐에서 꺼내오기
            int v = queue.poll();
            //목적지 인가?
            answer[v] = ++idx;
            //연결된 곳 순회하기
            for (int w : adjList[v]) {
                //갈 수 있는가?
                if(!visited[w]) {
                    //체크 인
                    visited[w] = true;
                    //큐에 넣기
                    queue.add(w);
                }
            }
        }
        for (int i = 1; i <= N; i++) System.out.println(answer[i]);
    }
}
