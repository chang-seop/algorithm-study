package StudyFiles.DijkstraAlgorithm.StudyFiles_LogScale;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘 시간복잡도 (N * log N)
// O(E log V) E -> 간선의 수 V -> 노드의 개수
public class Main {
    static boolean[] visited;
    static ArrayList<Node>[] map;
    static int[] dp;
    static int vCount;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DijkstraAlgorithm/StudyFiles_LogScale/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vCount = Integer.parseInt(br.readLine());

        visited = new boolean[vCount + 1];
        dp = new int[vCount + 1];

        // 인접리스트로 구현
        map = new ArrayList[vCount + 1];
        for (int i = 1; i <= vCount; i++) {
            map[i] = new ArrayList<>();
        }

        // 기본적으로 연결되지 않은 경우 비용은 무한 (20억)
        for (int i = 1; i <= vCount; i++) {
            dp[i] = 200000000;
        }

        // 입력 부분
        // 인접리스트 시간 복잡도 O(N * log N)
        // 이 경우 정점에 비해 간선의 갯수가 비정상적으로 적어도 안정적으로 처리 할 수 있습니다.
        for (int i = 1; i <= vCount; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= vCount; j++) {
                String request = st.nextToken();
                // 자기 노드 빼기
                if(i == j) continue;
                if(!request.equals("x")) map[i].add(new Node(j, Integer.parseInt(request)));
            }
        }

        // 알고리즘 실행
        dijkstra(1);

        // 출력
        for(int i = 1; i <= vCount; i++) System.out.print(dp[i] + " ");
    }

    static void dijkstra(int start) {
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(); //최소 힙 구조
        pq.add(new Node(start, 0)); // 큐에 넣기
        // 가까운 순서대로 처리하므로 큐를 사용합니다.
        while(!pq.isEmpty()) {
            int current = pq.peek().index;
            int distance = pq.peek().weight;
            pq.poll();

            //최단 거리가 아닌 경우 스킵
            if (dp[current] < distance) continue;
            for (int i = 0; i < map[current].size(); i++) {
                // 선택된 노드의 인접 노드
                int next = map[current].get(i).index;
                // 선택된 노드 거쳐서 인접 노드로 가는 비용 계산
                int nextDistance = distance + map[current].get(i).weight;
                // 기존의 최소 비용보다 더 저렴하다면 교체합니다.
                if (nextDistance < dp[next]) {
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
        // 오름차순
        return this.weight - o.weight;
    }
}