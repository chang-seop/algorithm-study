package StudyFiles.GreedyAlgorithm.P11047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Integer[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GreedyAlgorithm/P11047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nArray = new Integer[N];
        for (int i = N - 1; i >= 0 ; i--) {
            nArray[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if(K == 0) {
                break;
            }
            else if(K / nArray[i] >= 0) {
                count += K / nArray[i];
                K %= nArray[i];
            }
        }
        System.out.print(count);
    }
}
