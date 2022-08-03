package StudyFiles.TwoPointer.P3273;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int X;
    static Integer[] iArray, jArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/TwoPointer/P3273/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        iArray = new Integer[N];
        jArray = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            iArray[i] = jArray[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(iArray); // 오름차순
        Arrays.sort(jArray, Collections.reverseOrder()); // 내림차순

        // 2 - Pointer
        int ptr1 = 0, ptr2 = 0, count = 0, len = iArray.length;
        while(ptr1 < len && ptr2 < len) {
            if(iArray[ptr1] + jArray[ptr2] == X) {
                count++;
                ptr1++;
            } else if(iArray[ptr1] + jArray[ptr2] > X) {
                ptr2++;
            } else {
                ptr1++;
            }
        }
        System.out.println(count / 2);
    }
}
