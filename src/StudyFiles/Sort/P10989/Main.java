package StudyFiles.Sort.P10989;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] nArray = new int[10001]; // 최대 수
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P10989/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        // 카운팅 소트
        for (int i = 0; i < N; i++) nArray[Integer.parseInt(br.readLine())]++; // 입력
        for (int i = 1; i < nArray.length; i++) {
            if(nArray[i] == 0) continue;
            for (int j = 0; j < nArray[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
