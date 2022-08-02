package StudyFiles.P2231;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    static String nString;
    static int N;
    static int result = MAX_VALUE;
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P2231/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = N; i > 0; i--) {
            int temp = dp[i] + deComPosition(Integer.toString(dp[i]));
            if(temp == N) {
                result = Math.min(dp[i], result);
            }
        }
        if(result == MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }
    static int deComPosition(String n) {
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        return sum;
    }
}
