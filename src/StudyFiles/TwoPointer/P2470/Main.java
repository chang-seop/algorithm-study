package StudyFiles.TwoPointer.P2470;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/TwoPointer/P2470/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nArray = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nArray.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nArray); //양수
        int a = 0, b = 0;

        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;
        while(start < end) {
            int sum = nArray.get(start) + nArray.get(end);

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                a = nArray.get(start);
                b = nArray.get(end);
                if(sum == 0) break;
            }
            if(sum < 0) start++;
            else end--;
        }

        System.out.println(a + " " + b);
    }
}