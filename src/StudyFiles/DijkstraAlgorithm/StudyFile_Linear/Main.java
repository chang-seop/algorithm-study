package StudyFiles.DijkstraAlgorithm.StudyFile_Linear;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다익스트라 선형 알고리즘 O(V^2)
public class Main {
    static boolean[] visited;
    static int[][] map;
    static int[] dp;
    static int vCount;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DijkstraAlgorithm/StudyFile_Linear/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        vCount = Integer.parseInt(br.readLine());

        // 인접 행렬
        map = new int[vCount][vCount];
        visited = new boolean[vCount];
        dp = new int[vCount];

        // 입력 부분
        for (int i = 0; i < vCount; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < vCount; j++) {
                String request = st.nextToken();
                if(request.equals("x")) map[i][j] = 2000000000;
                else map[i][j] = Integer.parseInt(request);
            }
        }

        // 시작 노드는 0부터 !
        dijkstra(0);

        for(int i : dp) System.out.print(i + " ");
    }

    static int getSmallIndex() {
        // 현재 dp 에 저장된 최소 비용의 인덱스를 반환하는 함수
        int min = 2000000000;
        int index = 0;
        for (int i = 0; i < vCount; i++) {
            if(dp[i] < min && !visited[i]) {
                min = dp[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start) {
        // 시작 정점 dp 에 저장
        for (int i = 0; i < vCount; i++) {
            dp[i] = map[start][i];
        }
        // 시작 정점 방문 체크
        visited[start] = true;
        for (int i = 0; i < vCount; i++) {
            int currentIndex = getSmallIndex();
            // 현재 최소 비용 인덱스 방문 체크
            visited[currentIndex] = true;

            for (int j = 0; j < vCount; j++) {
                // 가고자 하는 곳이 방문하지 않았다면
                if(!visited[j]) {
                    // 현재 보고있는 그 노드 값(dp[CurrentIndex]) 까지의 최소 비용에서
                    // 그 노드를 거쳐서 그 노드의 인접한 노드(v[currentIndex][j])로 가는 비용을 더한 값이
                    // 현재 그 인접한 노드(dp[j])로 가는 최소 비용보다 더 작다면
                    if(dp[currentIndex] + map[currentIndex][j] < dp[j]) {
                        // dp 에 갱신
                        dp[j] = dp[currentIndex] + map[currentIndex][j];
                    }
                }
            }
        }
    }
}
