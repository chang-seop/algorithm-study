package StudyFiles.Sort.P23882;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P23882/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        // 선택 정렬
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            boolean visited = false;
            int max = nArray[i], pointer = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(max < nArray[j]){
                    max = nArray[j];
                    pointer = j;
                    visited = true;
                }
            }
            if(visited) {
                int temp = nArray[i];
                nArray[i] = nArray[pointer];
                nArray[pointer] = temp;
                count++;
                if(count == K) break;
            }
        }
        if(count < K) System.out.println(-1);
        else {
            for(int i : nArray) System.out.print(i + " ");
        }
    }
}
