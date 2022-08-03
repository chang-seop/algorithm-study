package SamsungAlgorithmStudy.DAY05.P1256;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합론 파스칼의 삼각형, Index Tree 와 비슷 N+M C M
public class Main {
    static int N, M, K;
    static int[][] dp = new int[201][201];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY05/P1256/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K > combination(N + M, M)) {
            System.out.println(-1);
        } else {
            query(N, M, K);
            System.out.println(sb);
        }
    }
    public static void query(int n, int m, int k) {
        // 단어 끝에 도달시 쿼리 종료
        if(n + m == 0) {
            return;
        }
        // z만 남은경우
        else if(n == 0){
            sb.append('z');
            query(n, m - 1, k);
        }
        // a만 남은경우
        else if(m == 0) {
            sb.append('a');
            query(n-1, m, k);
        }
        // a, z 둘다 남은 경우 a를 고를 때 조합 수를 보고 판단
        else {
            int leftCount = combination(n + m - 1, m); // 현재 기준 -1은 하나 고름
            if(leftCount >= k) {
                sb.append('a'); // a를 선택
                query(n - 1, m, k); // a를 골랐으니 n - 1, m 그대로, k 그대로
            } else {
                sb.append('z');
                query(n, m - 1, k - leftCount); // z를 골랐으니 n 그대로, m - 1, k - leftCount
            }
        }
    }

    //일반적인 combination 구하는 방법
    public static int combination(int n, int r) { // r = k
        if (n == r || r == 0) {
            return 1;
        } else if (dp[n][r] != 0){//한번 개선한 적이 있는 경우 재귀 탈 필요 x
            return dp[n][r];
        }
        else { //문제에서 최대값 (1e9를 넘을 수 있기 때문에 치환) (1e9 대신 k 값을 넣어도 된다!)
            return dp[n][r] = Math.min((int) 1e9, combination(n-1, r - 1) + combination(n - 1, r));
        }
    }
}
