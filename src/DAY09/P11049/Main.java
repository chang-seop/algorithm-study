package DAY09.P11049;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] rows = new int[N+1];
        st = new StringTokenizer(br.readLine());
        rows[0] = Integer.parseInt(st.nextToken());
        rows[1] = Integer.parseInt(st.nextToken());
        for(int i = 2 ; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            rows[i-1] = Integer.parseInt(st.nextToken());
            rows[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][N+1];

        //j = 구간 시작점
        //i = 구간 종료점
        //k = j <= k < i
        for(int i = 1; i <= N; i++){
            for(int j = i-1; j > 0; j--){
                int min = Integer.MAX_VALUE;
                for(int k = j; k < i; k++){
                    min = Math.min(min, dp[j][k]+dp[k+1][i]+rows[i]*rows[k]*rows[j-1]);
                }
                dp[j][i] = min;
            }
        }
        System.out.print(dp[1][N]);
    }
}