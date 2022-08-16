package StudyFiles.GraphCircuit.P24480;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int idx = 0;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/P24480/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        // 정점 초기화
        for (int i = 0; i <= N; i++) adjList[i] = new LinkedList<>();

        // 간선 초기화 및 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            adjList[m1].add(m2);
            adjList[m2].add(m1); // 무방향 그래프
        }
        // 내림차 순 정렬
        for (int i = 0; i <= N; i++) {
            adjList[i].sort(Collections.reverseOrder());
        }
        dfsList(R);
        for (int i = 1; i <= N ; i++) {
            System.out.println(answer[i]);
        }
    }
    static void dfsList(int v) {
        //체크인
        visited[v] = true;
        answer[v] = ++idx;
        //목적지 인가?
        //연결된 곳 순회하기
        for(int w : adjList[v]) {
            //갈 수 있는가
            if(!visited[w]) {
                //간다
                dfsList(w);
            }
        }
        //체크 아웃
    }
}
