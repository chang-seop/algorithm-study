package StudyFiles.DijkstraAlgorithm.P1753;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, start;
    static int[] dp;
    static ArrayList<Node>[] map;
    final static int MAX = 2000000000;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DijkstraAlgorithm/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // V : 정점의 개수, E : 간선의 개수
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 시작 정점
        start = Integer.parseInt(br.readLine());

        // 배열 초기화
        dp = new int[V + 1];
        map = new ArrayList[V + 1];
        // 인접리스트
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        // dp 초기화
        for (int i = 1; i <= V; i++) {
            dp[i] = MAX;
        }

        // 인접 리스트 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int tempStart = Integer.parseInt(st.nextToken());
            int tempEnd = Integer.parseInt(st.nextToken());
            int tempWeight = Integer.parseInt(st.nextToken());
            map[tempStart].add(new Node(tempEnd, tempWeight));
        }

        // 알고리즘 실행
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if(dp[i] == MAX) System.out.println("INF");
            else System.out.println(dp[i]);
        }
    }
    static void dijkstra() {
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 큐에 넣기
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            int current = pq.peek().index;
            int distance = pq.peek().weight;
            // 큐에서 가져오기
            pq.poll();

            if(distance > dp[current]) continue;
            for (int i = 0; i < map[current].size(); i++) {
                int next = map[current].get(i).index;
                int nextDistance = dp[current] + map[current].get(i).weight;

                if(nextDistance < dp[next]) {
                    dp[next] = nextDistance;
                    pq.add(new Node(next, nextDistance));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 오름차 순
        return this.weight - o.weight;
    }
}