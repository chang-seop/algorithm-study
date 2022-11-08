package StudyFiles.DynamicProgramming.P1904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DynamicProgramming/P1904/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001]; // 피보나치
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 1000001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[N - 1]);
    }
}
