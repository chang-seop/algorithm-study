package WorkingTable.P2981;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[] nArray;
    static List<Integer> answerArray;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P2981/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        answerArray = new ArrayList<>();
        for (int i = 0; i < N; i++)  {
            nArray[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nArray[i]);
        }
        for (int i = 1; i < N; i++) {
            // 큰 수에서 작은 수를 빼줌으로 서 나누어 떨어지면 값이 나옴!
            int temp = Math.abs(nArray[i] - nArray[i - 1]);
            int max = 0;

            if(nArray[i] > nArray[i - 1]) {
                max = nArray[i];
            } else max = nArray[i - 1];

            for (int j = 2; j <= Math.sqrt(max) * 2; j++) {
                if(temp % j == 0) {
                    answerArray.add(j);
                }
            }
        }

        Collections.sort(answerArray);
        int count = 1;
        boolean visited = false;
        for (int i = 1; i < answerArray.size(); i++) {
            visited = true;
            if(answerArray.get(i - 1) == answerArray.get(i)) {
                count++;
            }
            if(count == N - 1) {
                sb.append(answerArray.get(i - 1)).append(" ");
                count = 1;
            }
        }
        if(!visited) sb.append(answerArray.get(0)).append(" ");

        System.out.print(sb);
    }
}