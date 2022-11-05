package StudyFiles.BackTracking.P14889;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int selectedCount;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BackTracking/P14889/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectedCount = -1;
        dfs(0);
        System.out.print(min);
    }

    static void dfs(int index) {
        // 체크인
        visited[index] = true;
        selectedCount++;
        dp[index]++;

        if (selectedCount == N / 2) { // 예 ) 조합으로 N / 2개만 뽑기
            // 정답
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> link = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if(dp[i] == 1) start.add(i);
                else link.add(i);
            }

            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    if(i == j) continue; // 중복 제거
                    startSum += map[start.get(i)][start.get(j)];
                    linkSum += map[link.get(i)][link.get(j)];
                }
            }

            min = Math.min(min, Math.abs(startSum - linkSum));
            if(min == 0) return;
        } else {
            // 연결된 곳 순회하기 : 조합
            for (int i = index + 1; i <= N; i++) {
                // 갈 수 있는가
                if (!visited[i]) {
                    // 간다
                    dfs(i);
                }
            }
        }

        // 체크아웃
        selectedCount--;
        dp[index]--;
        visited[index] = false;
    }
}