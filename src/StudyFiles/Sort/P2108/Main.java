package StudyFiles.Sort.P2108;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nArray;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P2108/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        dp = new int[8001];
        double average = 0;
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(br.readLine());
            dp[nArray[i] + 4000]++;
            average += nArray[i];
        }
        System.out.println(Math.round(average / N)); // 산술 평균
        Arrays.sort(nArray);
        System.out.println(nArray[(nArray.length - 1) / 2]); // 중앙 값
        //입력되는 정수의 절댓값은 4000을 넘지 않으므로 4000을 더함
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            if(dp[i] == 0) continue;
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        int count = 0;
        for (int i = 0; i < 8001; i++) {
            if(dp[i] == 0) continue;
            if(max == dp[i]) {
                count++;
            }
        }

        boolean visited = false;
        for (int i = 0; i < 8001; i++) {
            if(dp[i] == 0) continue;
            if(max == dp[i] && visited) { // 두번째로 작은값
                System.out.println(i - 4000);
                break;
            }
            if(max == dp[i]) {
               visited = true; // 두번째로 작은값을 가기 위함
            }
            if(max == dp[i] && count == 1) {
                System.out.println(i - 4000);
                break;
            }
        }
        System.out.println(Math.abs(nArray[nArray.length - 1] - nArray[0])); // 범위
    }
}