package WorkingTable.P1450;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, C; // N : 물건 개수 C : 최대 C 만큼의 무게를 넣을 수 있는 가방 하나
    static int[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1450/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 부분
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        nArray = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = nArray.length - 1;
        int count = 1;
        int start = 0;
        int end = 0;
        int sum = nArray[start];
        boolean visited1 = false;
        boolean visited2 = false;
        while(start <= end) {
            if(nArray[end] == sum) visited1 = true;
            if(sum <= C) count++;
            if(nArray[start] + nArray[end] == sum) visited2 = true;
            if((sum < C || visited1) && !visited2) {
                visited1 = false;
                if(end + 1 > maxLength) break;
                sum += nArray[++end];
            } else {
                visited2 = false;
                if(start + 1 > maxLength) break;
                sum -= nArray[start++];
            }
        }


        System.out.println(count);
    }
}
