package StudyFiles.Recursion.P24060;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, mergeCount, mergeK;
    static int[] nArray, tmp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Recursion/P24060/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nArray = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        mergeCount = 0;
        mergeSort(0, N - 1);

        if(mergeCount < K) System.out.print(-1);
        else System.out.print(mergeK);

    }
    static void mergeSort(int first, int last) {
        if(first < last) {
            int mid = (first + last) / 2; //
            mergeSort(first, mid); // 전반부 정렬
            mergeSort(mid + 1, last); // 후반부 정렬
            merge(first, mid, last); // 병합
        }
    }
    static void merge(int first, int mid, int last) {
        int p = first, q = mid + 1, idx = first;
        while(p <= mid && q <= last) {
            if(nArray[p] <= nArray[q]) {
                tmp[idx++] = nArray[p++];
            } else tmp[idx++] = nArray[q++];
        }
        while(p <= mid) { // 왼쪽 배열 부분이 남은 경우
            tmp[idx++] = nArray[p++];
        }
        while(q <= last) { // 오른쪽 배열 부분이 남은 경우
            tmp[idx++] = nArray[q++];
        }
        p = idx = first;
        while(p <= last) { // 결과를 nArray[first..last]에 저장
            int temp = nArray[p++] = tmp[idx++];
            mergeCount++;
            if(mergeCount == K) {
                mergeK = temp;
            }
        }
    }
}
