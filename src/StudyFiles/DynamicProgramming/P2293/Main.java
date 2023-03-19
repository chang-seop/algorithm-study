package StudyFiles.DynamicProgramming.P2293;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static final int MAX = 10001;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DynamicProgramming/P2293/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Integer> nList = new ArrayList<>();
        int[] dp = new int[MAX];

        // 입력
        while(n-- > 0) nList.add(Integer.parseInt(br.readLine()));

        // DP
        dp[0] = 1;
        for (Integer num : nList) {
            for (int i = num; i <= k; i++) {
                int temp = i - num;
                dp[i] = dp[i] + dp[i - num];
                System.out.print("|i = " + i + " dp[i] = " + dp[i] + " temp = " + temp + "| ");
            }
            System.out.println();
        }
        /*
        점화식 출력
        |i = 1 dp[i] = 1 temp = 0| |i = 2 dp[i] = 1 temp = 1| |i = 3 dp[i] = 1 temp = 2| |i = 4 dp[i] = 1 temp = 3| |i = 5 dp[i] = 1 temp = 4| |i = 6 dp[i] = 1 temp = 5| |i = 7 dp[i] = 1 temp = 6| |i = 8 dp[i] = 1 temp = 7| |i = 9 dp[i] = 1 temp = 8| |i = 10 dp[i] = 1 temp = 9|
        |i = 2 dp[i] = 2 temp = 0| |i = 3 dp[i] = 2 temp = 1| |i = 4 dp[i] = 3 temp = 2| |i = 5 dp[i] = 3 temp = 3| |i = 6 dp[i] = 4 temp = 4| |i = 7 dp[i] = 4 temp = 5| |i = 8 dp[i] = 5 temp = 6| |i = 9 dp[i] = 5 temp = 7| |i = 10 dp[i] = 6 temp = 8|
        |i = 5 dp[i] = 4 temp = 0| |i = 6 dp[i] = 5 temp = 1| |i = 7 dp[i] = 6 temp = 2| |i = 8 dp[i] = 7 temp = 3| |i = 9 dp[i] = 8 temp = 4| |i = 10 dp[i] = 10 temp = 5|
        */

        System.out.print(dp[k]);
    }
}
