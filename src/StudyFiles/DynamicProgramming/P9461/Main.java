package StudyFiles.DynamicProgramming.P9461;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DynamicProgramming/P9461/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        while(T -- > 0) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
