package WorkingTable.P1912;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nArray, dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1912/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArray = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + nArray[i];
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        boolean visited = false;
        for (int i = 0; i <= N - 1; i++) {
            if(dp[i] < dp[i + 1]) {
                visited = true;
                sum += dp[i + 1] - dp[i];
            } else {
                maxValue = Math.max(maxValue, dp[i + 1] - dp[i]);
                sum = 0;
            }
            max = Math.max(max, sum);
        }

        if(!visited) System.out.println(maxValue);
        else System.out.println(max);
    }
}
