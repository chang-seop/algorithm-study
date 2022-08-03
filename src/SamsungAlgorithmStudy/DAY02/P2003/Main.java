package SamsungAlgorithmStudy.DAY02.P2003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY02/P2003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        int high = 0, low = 0, sum = nums[0], count = 0;
        while (true) {
            if(sum == M) {
                count++;
                sum -= nums[low++];
            } else if(sum > M) {
                sum -= nums[low++];
            } else {
              sum += nums[++high];
            }
            if(high == N) break;
        }
        System.out.println(count);
    }
}
