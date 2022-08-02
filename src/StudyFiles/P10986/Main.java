package StudyFiles.P10986;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] dp = new long[1000001];
    static long[] sum = new long[1000001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P10986/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Long.parseLong(st.nextToken());
        }
        
        int count = 0;
        sum[0] = dp[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + dp[i];
            if(dp[i] % M == 0) count++;
        }

        for (int i = N - 1; i > 0; i--) {
            long last = sum[i];
            if(last - dp[i] % M == 0) count++;
        }
        System.out.println(count);
    }
}
