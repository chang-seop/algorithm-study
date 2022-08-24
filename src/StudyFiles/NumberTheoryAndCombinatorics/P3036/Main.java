package StudyFiles.NumberTheoryAndCombinatorics.P3036;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheoryAndCombinatorics/P3036/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int temp = nArray[0];
            for (int j = 1000; j > 0; j--) {
                if(temp % j == 0 && nArray[i] % j == 0) {
                    temp /= j;
                    nArray[i] /= j;
                }
            }
            System.out.println(temp + "/" + nArray[i]);
        }
    }
}
