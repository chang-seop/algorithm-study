package StudyFiles.GraphCircuit.BFS.P2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 정점, 간선
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //정점 초기화
        adjList = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<>();
        }

        //간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            //무방향 간선
            adjList[m1].add(m2);
            adjList[m2].add(m1);
        }

        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        //큐에 넣기
        queue.add(1); //1번 컴퓨터
        visited[1] = true;

        while(!queue.isEmpty()) {
            //큐에서 가져오기
            int v = queue.poll();
            answer[v] = 1;
            //목적지인가?
            //연결된곳 순회
            for (int w : adjList[v]) {
                //갈 수 있는가
                if(!visited[w]) {
                    //체크 인
                    visited[w] = true;
                    //큐에 넣기
                    queue.add(w);
                }
            }
        }
        int count = -1; // 1번 컴퓨터 제외
        for (int i = 1; i <= N; i++) {
            if(answer[i] != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
