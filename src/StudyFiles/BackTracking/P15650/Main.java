package StudyFiles.BackTracking.P15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 -> DFS 깊이 우선 탐색
public class Main {
    static int N, M, length;
    static boolean[] visited;
    static int selectedCount;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BackTracking/P15650/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //경우의 수 구하기 n!/(n-r)!
        length = factorial(N) / factorial(N - M);
        visited = new boolean[length + 1];

        selectedCount = -1;

        dfs(0, "");
    }
    static void dfs(int index, String result) {
        // 체크인
        visited[index] = true;
        selectedCount++;
        // 목적지인가?
        if(selectedCount == M) {
            // 정답
            System.out.println(result);
        } else {
            // 연결된 곳 순회하기
            for (int i = index + 1; i <= N; i++) {// 이미 간 곳은 for 문으로
                // 갈 수 있는가?
                if(!visited[i]) {
                    // 간다
                    dfs(i, result + Integer.toString(i) + " ");
                }
            }
        }
        // 체크아웃
        selectedCount--;
        visited[index] = false;
    }
    static int factorial(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

}
