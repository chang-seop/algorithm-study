package StudyFiles.BruteForceAlgorithm.P2798;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] nArray;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BruteForceAlgorithm/P2798/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nArray = new int[N];
        visited = new boolean[N];
        result = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0);
        System.out.println(answer);
    }
    static void dfs(int depth) {
        if(depth == 3) {
            int sum = 0;
            for (int i : result) {
                sum += i;
            }
            if(sum > M) {
                return;
            }
            if(sum <= M) {
                answer = Math.max(answer, sum);
            }
        } else {
            for (int i = depth; i < N; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    result[depth] = nArray[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
