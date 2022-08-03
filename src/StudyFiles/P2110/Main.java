package StudyFiles.P2110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] nArray;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P2110/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        nArray = new int[N];
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nArray);

        int index = (nArray.length - 1) / M;

        int high = dp.length - 1;
        int low = 0;
        int mid = 0;
        int target = nArray[index];
        while(low <= high) {
            mid = (high + low) / 2;

        }
    }
}
