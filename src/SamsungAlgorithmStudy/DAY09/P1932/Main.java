package SamsungAlgorithmStudy.DAY09.P1932;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        //점화식: dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                int lt = j-1 < 0 ? 0 : dp[i-1][j-1];
                int rt = dp[i-1][j];
                dp[i][j] = Math.max(lt, rt) + triangle[i][j];
            }
        }
        for(int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[N-1][i]);
        }
        System.out.println(ans);
    }
}