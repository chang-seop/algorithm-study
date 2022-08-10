package StudyFiles.MathWithImplement.P3003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P3003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nArray = new int[6];

        for (int i = 0; i < 6; i++) {
            int n = Integer.parseInt(st.nextToken());
            nArray[i] = dp[i] - n;
        }

        for(int n : nArray) {
            System.out.print(n + " ");
        }

    }
}
