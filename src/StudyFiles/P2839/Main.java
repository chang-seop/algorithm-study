package StudyFiles.P2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] bags = { 3, 5 };
    static int[] dp1, dp2;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P2839/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp1 = new int[N];
        dp2 = new int[N];

        for (int i = 0; i < N; i++) dp1[i] += bags[0] * i; // 0, 3, 6, 9 ...
        for (int i = 0; i < N; i++) dp2[i] += bags[1] * i; // 0, 5, 10, 15 ...

        for (int i = 0; i < N; i++) { // O(N log N)
            int high = N - 1;
            int low = 0;
            int mid = 0;
            int target = N;

            while(low <= high) { // 이분 탐색
                mid = (high + low) / 2;
                if(dp2[mid] + dp1[i] == target) {
                    int sum = (dp2[mid] / bags[1]) + (dp1[i] / bags[0]);
                    System.out.println(sum);
                    return;
                } else if(dp2[mid] + dp1[i] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        System.out.println(-1);
    }
}
