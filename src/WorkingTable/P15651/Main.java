package WorkingTable.P15651;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P15651/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0, -1, "");
        System.out.println(sb);
    }
    static void dfs(int index, int count, String temp) {
        //체크인
        count++;
        //목적지인가? (count == M)
        if(count == M) {
            sb.append(temp).append("\n");
        } else {
            //연결된 곳 순회
            for (int i = 1 ; i <= N; i++) { // 순열
                // 간다
                dfs(i, count, temp + Integer.toString(i) + " ");
            }
        }
        // 체크 아웃
    }
}
