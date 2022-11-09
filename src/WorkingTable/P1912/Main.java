package WorkingTable.P1912;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nArray, dp;
    static int max = Integer.MIN_VALUE, maxIndex;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1912/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArray = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
            if(max < nArray[i]) {
                max = nArray[i];
                maxIndex = i;
            }
        }
        // 부분 합
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + nArray[i];
        }
        max = Integer.MIN_VALUE;

        for (int i = 0; i < maxIndex; i++) {
            if(dp[maxIndex] - dp[i] > max) {
                max = dp[maxIndex] - dp[i];
            }
        }
        System.out.print(max);
    }
}
