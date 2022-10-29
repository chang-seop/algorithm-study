package StudyFiles.GreedyAlgorithm.P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] timeArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GreedyAlgorithm/P1931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        timeArray = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeArray[i][0] = Integer.parseInt(st.nextToken()); // first time
            timeArray[i][1] = Integer.parseInt(st.nextToken()); // last time
        }

        Arrays.sort(timeArray, (int[] a, int[] b) -> {
            if(a[1] == b[1]) { // this last == other last
                return a[0] - b[0]; // this first - other first
            } else return a[1] - b[1]; // this last - other last
        });

        int count = 1;
        int firstTime = timeArray[0][1]; // 가장 적은 끝나는 시간을 먼저 접근 (그리디)
        for (int i = 1; i < timeArray.length; i++) { // 먼저 접근 했으므로 0 index 건너 띄우기
            int[] temp = timeArray[i];
            if(firstTime <= temp[0]) { // 다음 시작 시간이 전 끝나는 시간 보다 크거나 같을 경우
                count++;
                firstTime = temp[1];
            }
        }
        System.out.print(count);
    }
}