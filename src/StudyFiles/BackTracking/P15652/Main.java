package StudyFiles.BackTracking.P15652;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BackTracking/P15652/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(1, -1, ""); //초기에 1을 줌으로써 0 인덱스 제거
        System.out.print(sb);
    }
    static void dfs(int index, int count, String temp) { //방문 체크 X
        //체크인
        count++;
        //목적지인가?
        if(count == M) {
            sb.append(temp).append("\n");
        } else {
            // 연결된 곳 순회하기
            for (int i = index; i <= N; i++) { // 비 내림차 순, 중복되는 수열 X
                // 갈 수 있는가?
                dfs(i, count, temp + Integer.toString(i) + " ");
            }
        }
        // 체크아웃
    }
}
