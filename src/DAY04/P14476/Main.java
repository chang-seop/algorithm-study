package DAY04.P14476;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//누적 gcd
public class Main {
    static int N;
    static int[] nums;
    static int[] gcdLtoR;
    static int[] gcdRtoL;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/DAY04/P14476/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        nums = new int[N];
        gcdLtoR = new int[N];
        gcdRtoL = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //LtoR 만들기
        gcdLtoR[0] = nums[0];
        for (int i = 1; i < N; i++) {
            gcdLtoR[i] = gcd(gcdLtoR[i - 1], nums[i]);
        }
        //RtoL 만들기
        gcdLtoR[0] = nums[0];
        for (int i = N - 2; i >= 0; i--) {
            gcdRtoL[i] = gcd(gcdRtoL[i + 1], nums[i]);
        }

        //k 선정하기
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            // 0
            if (i == 0) {
                gcd = gcdRtoL[1];
            }
            // n - 1일때
            else if(i == N - 1) {
                gcd = gcdLtoR[N - 2];
            }
            // 중간
            else {
                gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]);
            }
            if(nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }
        if(max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(max + " " + maxIndex);
        }
    }
    //gcd(a, b) == gcd(b, r) == gcd(b, a % b), stop when a % b == 0
    static int gcd(int a, int b) {
        return gcd(a, a % b);
    }
}
