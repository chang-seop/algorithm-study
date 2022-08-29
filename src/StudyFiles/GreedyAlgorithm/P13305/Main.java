package StudyFiles.GreedyAlgorithm.P13305;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] oilArray, distanceArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GreedyAlgorithm/P13305/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력
        N = Integer.parseInt(br.readLine());
        distanceArray = new long[N - 1]; // 거리
        oilArray = new long[N - 1]; // 기름
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            distanceArray[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) { // 목적지는 필요 없음
            oilArray[i] = Integer.parseInt(st.nextToken());
        }

        // 알고리즘
        long sum = 0;
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < N - 1) {
            if(oilArray[ptr1] < oilArray[ptr2]) {
                ptr2 = ptr1;
            }

            sum += distanceArray[ptr1++] * oilArray[ptr2];
        }

        System.out.println(sum);
    }
}
