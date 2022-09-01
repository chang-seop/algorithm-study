package StudyFiles.Combinatorics.P11051;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Combinatorics/P11051/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        System.out.println(combination(N, K));
        // 반복문을 이용한 파스칼 삼각형 구하기 ( 이항 계수 )
//        for (int i = 0; i < N + 1; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 0; i < K + 1; i++) {
//            dp[i][i] = 1;
//        }
//
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < K + 1; j++) {
//                dp[i][j] =(dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
//            }
//        }
    }
    static int combination(int N, int K) {
        // 값을 재활용
        if(dp[N][K] > 0) {
            return dp[N][K];
        }

        if(K == 0 || N == K) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = (combination(N - 1, K) + combination(N - 1, K - 1)) % 10007;
    }

}
