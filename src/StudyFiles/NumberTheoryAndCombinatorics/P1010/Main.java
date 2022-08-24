package StudyFiles.NumberTheoryAndCombinatorics.P1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int testCase, K, N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheoryAndCombinatorics/P1010/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());

        dp = new int[31][31];
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            System.out.println(combination(N, K));
        }


    }
    static int combination(int n, int m) {

        // 이미 값이 있으면 값 리턴
        if(dp[n][m] > 0) {
            return dp[n][m];
        }

        if(m == 0 || n == m) {
            return 1;
        }

        return dp[n][m] = combination(n - 1, m) + combination(n - 1, m - 1);
    }
}
