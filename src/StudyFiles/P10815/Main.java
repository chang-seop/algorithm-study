package StudyFiles.P10815;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nArray, mArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P10815/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];

        st =  new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nArray[n] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mArray = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            mArray[m] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArray);

        // 이분 탐색
        for (int i = 0; i < mArray.length; i++) {
            int high = nArray.length - 1;
            int low = 0, mid = 0;
            int target = mArray[i];
            boolean visited = false;

            while(low <= high) {
                mid = (high + low) / 2;
                if(nArray[mid] == target) {
                    System.out.print(1 + " ");
                    visited = true;
                    break;
                }
                else if(nArray[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if(!visited) {
                System.out.print(0 + " ");
            }
        }
    }
}
