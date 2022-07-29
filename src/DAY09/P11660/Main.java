package DAY09.P11660;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][N+1];
        for(int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            int x_sum = 0;
            //dp[y][x] : (1,1) ~ (y,x) 영역의 합
            for(int x = 1; x <= N; x++) {
                x_sum += Integer.parseInt(st.nextToken());
                dp[y][x] = dp[y-1][x] + x_sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        int x1, y1, x2, y2;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            int ans = dp[y2][x2] - dp[y1-1][x2] - dp[y2][x1-1] + dp[y1-1][x1-1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}