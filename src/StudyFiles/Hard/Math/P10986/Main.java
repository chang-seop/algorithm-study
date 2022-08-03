package StudyFiles.Hard.Math.P10986;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] dp = new long[1000001];
    static long[] sum = new long[1000001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Hard/Math/P10986/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] count = new int[M];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            count[sum]++;
        }

        long result;
        result = count[0];

        for (int i = 0; i < M; i++) {
            result += (long) count[i] * (count[i] - 1) / 2;
        }
        System.out.println(result);
    }
}
