package DAY02.P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S, N;
    static int[] nums;
    public static void main(String[]args) throws IOException {
        System.setIn(new FileInputStream("src/DAY02/P1806/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        int high = 0; // end index
        int low = 0; // start index
        int sum = nums[0]; // 합 계산
        int minLength = Integer.MAX_VALUE; // 초기화
        while(true) {
            if(sum >= S) {
                minLength = Math.min(high - low + 1, minLength);
                sum -= nums[low++];
            } else if(sum < S){
                sum += nums[++high];
            }
            if(high == N) break;
        }

        if(minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}
