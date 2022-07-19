package DAY02.P1072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long X; // 게임 횟수
    static long Y; // 이긴 게임 횟수
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY02/P1072/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        // 이분 탐색
        long compare = 100 * Y / X;
        long target = 0;
        long high = X, low = 0, mid = 0;
        long result = 0;
        while(low <= high) {
            mid = (high + low) / 2;
            target = 100 * (Y + mid) / (X + mid);
            if(target > compare) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(result == 0) System.out.println(-1);
        else System.out.println(result);
    }
}
