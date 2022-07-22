package DAY05.P1722;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs 방문체크 개념이 필요해다!
public class Main {
    static int N;
    static int[] nums;
    static long[] fact = new long[21];

    static long[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY05/P1722/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());

        if(command == 1) { // 1인 경우 k(1 <= k <= N!)를 입력 받는다
            long target = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) { // N! / (N - K)!
                    if(visited[j]) { // visited[j] == true 일경우 continue
                        continue;
                    }
                    if(target > fact[N - i - 1]) { // 만약 N 이 4일경우  4 - i - 1 -> fact[3]
                        target -= fact[N - i - 1];
                    } else {
                        sb.append(j);
                        sb.append(" ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        } else if (command == 2){ // 2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다.
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < nums[i]; j++) { //앞에 몇개있는건지만 보면 되니 nums[i] 까지
                    if(visited[j] == false) {
                        result += fact[N - i - 1];
                    }
                }
                visited[nums[i]] = true;
            }
            System.out.println(result + 1); //앞에 올 수 있는 가지 수 + 1
        }
    }
}
