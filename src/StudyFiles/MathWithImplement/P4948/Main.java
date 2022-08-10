package StudyFiles.MathWithImplement.P4948;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P4948/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[1000001];
        dp[0] = dp[1] = 1;
        int T = 1;

        while(true) {
            T = Integer.parseInt(br.readLine());
            int count = 0;

            //탈출 조건
            if(T == 0) break;


            // n 보다 크고, 2n 보다 작거나 같은 소수의 개수
            for (int i = 2; i < Math.sqrt(2 * T); i++) {
                if(dp[i] != 0) continue;
                for (int j = i * i; j <= 2 * T; j += i) {
                    if(dp[j] == 0) {
                        dp[j]++;
                    }
                }
            }

            // 출력
            for (int i = T + 1; i <= 2 * T ; i++) {
                if(dp[i] == 0) count++;
            }

            System.out.println(count);
        }
    }
}
