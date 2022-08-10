package StudyFiles.MathWithImplement.P2775;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, A, B;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P2775/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            A = Integer.parseInt(br.readLine());
            B = Integer.parseInt(br.readLine());
            dp = new int[B];
            for (int j = 0; j < B; j++) {
                dp[j] = j + 1;
            }

            for (int j = 0; j < A; j++) {
                for (int k = 1; k < B; k++) {
                    dp[k] = dp[k - 1] + dp[k];
                }
            }
            System.out.println(dp[B - 1]);
        }
    }
}
