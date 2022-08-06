package WorkingTable.P2470;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Integer[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P2470/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nArray = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             nArray[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차 순, 내림차 순
        Arrays.sort(nArray);

        // two pointer
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (end <= N) {
            int temp = nArray[start] + nArray[end];
            if(temp < min && temp > 0) {
                min = temp;
                end++;
            } else if(temp > max && temp < 0) {
                max = temp;
                end++;
            }
            start++;
        }
    }
}