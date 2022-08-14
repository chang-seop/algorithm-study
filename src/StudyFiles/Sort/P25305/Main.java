package StudyFiles.Sort.P25305;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, k;
    static int[] dp = new int[10001];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P25305/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        //카운팅 소트
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(temp, max);
            dp[temp]++;
        }
        int count = 0;
        for (int i = max; i >= 0; i--) {
            if(dp[i] == 0) continue;
            while(dp[i] != 0) {
                if(count == k) break;
                dp[i]--;
                count++;
            }
            if(count == k) {
                System.out.println(i);
                return;
            }
        }
    }
}
