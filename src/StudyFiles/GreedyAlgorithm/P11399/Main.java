package StudyFiles.GreedyAlgorithm.P11399;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main  {
    static int N;
    static int[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GreedyAlgorithm/P11399/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(nArray);

        // 누적합 배열
        int sum = nArray[0];
        for (int i = 1; i < N; i++) {
            sum += nArray[i];
            nArray[i] = sum;
        }

        sum = 0;
        for(int i : nArray) sum += i;
        System.out.print(sum);
    }
}
