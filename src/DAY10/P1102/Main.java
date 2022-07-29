package DAY10.P1102;

import java.io.*;
import java.util.*;

public class Main {
    static final int MAXN = 1000;
    static int N, P, X;
    static int D[][], dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[1<<N];

        Arrays.fill(dp, -1);

        D = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sts = 0;
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if(c == 'Y') sts |= 1 << i;
        }
        P = Integer.parseInt(br.readLine());
        int ans = dfs(sts);
        bw.write(((ans > 999999) ? -1 : ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bit_count(int sts) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if ((sts & (1 << i)) > 0) cnt++;
        }
        return cnt;
    }

    public static int min_path(int sts, int to) {
        int ret = 999999;
        for (int from = 0; from < N; from++) {
            if ((sts & (1 << from)) > 0) {
                ret = Math.min(ret, D[from][to]);
            }
        }
        return ret;
    }

    public static int dfs(int sts) {
        int cost;
        if (bit_count(sts) >= P) return 0;
        if (dp[sts] != -1) return dp[sts];
        dp[sts] = 9999999;
        for (int to = 0; to < N; to++) {
            if ((sts & (1 << to)) == 0) {
                cost = min_path(sts, to);
                dp[sts] = Math.min(dp[sts], dfs(sts | (1 << to))+cost);
            }
        }
        return dp[sts];
    }
}