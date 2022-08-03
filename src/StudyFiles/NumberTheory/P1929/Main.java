package StudyFiles.NumberTheory.P1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheory/P1929/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[1000001];

//        dp[0] = -1;
//        dp[1] = -1;
//        for (int i = 2; i <= Math.sqrt(N); i++) {
//            if(dp[i]==-1) continue;
//            for (int j = i * 2; j <= N; j += i) {
//                dp[j] = -1;
//            }
//        }
//        for (int i = M; i <= N; i++) {
//            if(dp[i] != -1) System.out.println(i);
//        }
        for (int i = M; i <= N; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }
    static boolean isPrime(int value) {
        if(value < 2) return false;
        int end = (int)Math.sqrt(value);
        for (int i = 2; i <= end; i++) {
            if(value % i == 0) return false;
        }
        return true;
    }
}
