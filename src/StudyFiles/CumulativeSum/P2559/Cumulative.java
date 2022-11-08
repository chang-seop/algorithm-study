package StudyFiles.CumulativeSum.P2559;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cumulative {
    static int N, K;
    static int[] nArray, dp;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/CumulativeSum/P2559/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }
        // 누적 합
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + nArray[i];
        }
        for (int i = 1; i <= N - (K - 1); i++) {
            max = Math.max(dp[i + (K - 1)] - dp[i - 1], max);
        }
        System.out.print(max);
    }
}
