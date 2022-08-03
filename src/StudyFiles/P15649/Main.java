package StudyFiles.P15649;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int selectedCount;
    static int length;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P15649/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //N P M
        length = factorial(N) / factorial(N - M);
        visited = new boolean[length + 1];

        selectedCount = -1;

        dfs(0, "");
    }

    static void dfs(int index, String temp) { // 조합
        // 체크인
        visited[index] = true;
        selectedCount++;
        // 목적지인가?
        if(selectedCount == M) {
            System.out.print(temp + "\n");
        } else {
            // 연결된 곳 순회하기
            for (int i = 1; i <= N; i++) { // 1 ~ 4
                // 갈수 있는 가?
                if(!visited[i]) {
                    // 간다
                    dfs(i, temp + Integer.toString(i) + " ");
                }
            }
        }
        // 체크아웃
        selectedCount--;
        visited[index] = false;
    }

    static int factorial(int x) {
        int sum = 1;
        for (int i = 2; i <= x; i++) {
            sum *= i;
        }
        return sum;
    }
}