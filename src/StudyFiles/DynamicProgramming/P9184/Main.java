package StudyFiles.DynamicProgramming.P9184;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DynamicProgramming/P9184/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        A = B = C = 0;
        dp = new int[21][21][21];

        while(true) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // 탈출 조건
            if(A == -1 && B == -1 && C == -1) break;

            System.out.println("w(" + A + ", " + B + ", " + C + ") = " + recursion(A, B, C));
        }

    }
    static int recursion(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;
        if(a > 20 || b > 20 || c > 20)
            return recursion(20, 20, 20);
        if(dp[a][b][c] != 0)
            return dp[a][b][c];
        if(a < b && b < c) {
            return dp[a][b][c] = recursion(a, b, c-1) + recursion(a, b-1, c-1) - recursion(a, b-1, c);
        }
        else {
            return dp[a][b][c] = recursion(a-1, b, c) + recursion(a-1, b-1, c) + recursion(a-1, b, c-1) - recursion(a-1, b-1, c-1);
        }
    }

}
