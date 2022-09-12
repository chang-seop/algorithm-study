package StudyFiles.DynamicProgramming.P24416;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, recursionCount, forCount;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DynamicProgramming/P24416/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        forCount = 0;
        recursionCount = 0;

        // 동적 계획법
        dp[1] = 1;
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            forCount++;
        }
        fibo(N);

        System.out.print(recursionCount + " " + forCount);
    }
    static int fibo (int n) {
        if(n == 1 || n == 2) {
            recursionCount++;
            return 1;
        }
        else return fibo(n - 1) + fibo(n - 2);
    }
}
