package DAY10.P7579;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dp[][], m[], c[], N, M, totalCost = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N];
        c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            m[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            totalCost += c[i];
        }
        dp = new int[N+1][totalCost + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= totalCost; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-c[i-1] >= 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i-1]] + m[i-1]);
            }
        }
        int ans = -1;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[N][i] >= M) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}