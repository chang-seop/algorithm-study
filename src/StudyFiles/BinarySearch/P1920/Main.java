package StudyFiles.BinarySearch.P1920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static long[] nArray;
    static long[] mArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BinarySearch/P1920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nArray = new long[N];
        for (int n = 0; n < N; n++) {
            nArray[n] = Long.parseLong(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        mArray = new long[M];
        for (int m = 0; m < M; m++) {
            mArray[m] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nArray); // n log n

        for (int i = 0; i < M; i++) { // n
            //2분 탐색
            long target = mArray[i];
            int high = N - 1; // 조심! 탐색 대상은 N !
            int low = 0;
            int mid = 0;
            boolean visited = false;

            while(low <= high) {  // log n
                mid = (high + low) / 2;
                if(target == nArray[mid]) {
                    System.out.println(1);
                    visited = true;
                    break;
                } else if (nArray[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if(!visited) {  // n * log n = O(n log n)
                System.out.println(0);
            }
        }
    }
}
