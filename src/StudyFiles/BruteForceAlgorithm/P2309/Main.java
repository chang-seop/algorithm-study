package StudyFiles.BruteForceAlgorithm.P2309;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] iArray;
    static boolean[] visited;
    static String answer;
    static List<Integer> answerArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BruteForceAlgorithm/P2309/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        iArray = new int[9];
        visited = new boolean[9];

        answerArray = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            iArray[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            dfs(i, 0, 0, "");
        }
        StringTokenizer st = new StringTokenizer(answer, " ");
        for (int i = 0; i < 7; i++) {
            answerArray.add(Integer.parseInt(st.nextToken()));
        }

        answerArray.sort(Comparator.naturalOrder());

        for (int i = 0; i < answerArray.size(); i++) {
            System.out.println(answerArray.get(i));
        }
    }
    static void dfs(int index, int sum, int count, String ans) { // 깊이 우선 탐색
        // 1. 체크인
        visited[index] = true;
        sum += iArray[index];
        ans += " " + Integer.toString(iArray[index]);

        // 2. 목적지 인가?
        if(count == 7 - 1 && sum == 100) {
            answer = ans;
            return;
        } else {
            // 3. 순회하기
            for (int i = index + 1; i < 9; i++) {
                // 4. 갈 수 있는가?
                if(!visited[i]) {
                    // 5. 간다
                    dfs(i, sum, count + 1, ans);
                }
            }
        }
        // 6. 체크아웃
        visited[index] = false;
    }
}
