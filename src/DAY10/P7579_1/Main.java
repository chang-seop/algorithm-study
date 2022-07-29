package DAY10.P7579_1;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dp[], m[], c[], N, M, totalCost = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N];
        c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            m[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            totalCost += c[i];
        }
        dp = new int[totalCost + 1];
        //dp[cost] = 앱들을 활성화한 비용이 cost일 때 확보한 최대 메모리 바이트 수
        for (int i = 0; i < N; i++) {
            //만약 c[0] -> totalCost 순으로 진행한다면, i번째 app을 여러 번 사용하는 결과 발생.
            //역순으로 진행해야 dp[j-c[i]]는 i번째 app을 사용하지 않은 cost임이 보장된다.
            for (int j = totalCost; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
            }
        }
        int ans = -1;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}