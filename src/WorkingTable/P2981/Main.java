package WorkingTable.P2981;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] nArray;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P2981/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        nArray = new int[N];
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < N; i++)  {
            nArray[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            // 큰 수에서 작은 수를 빼줌으로 서 나누어 떨어지면 값이 나옴!
            int temp = Math.abs(nArray[i] - nArray[i + 1]);

            max = Math.max(max, temp);

            for (int j = 2; j <= N; j++) {
                if(temp % j == 0) {
                    if(!hash.containsKey(j)) {
                        hash.put(j, 1);
                    } else {
                        hash.put(j, hash.get(j) + 1);
                    }
                }
            }
        }

        int temp = 0;
        for (Integer s : hash.keySet()) {
            if(hash.get(s) == N - 1) {
                sb.append(s).append(" ");
            }
        }

        System.out.print(sb);
    }
}