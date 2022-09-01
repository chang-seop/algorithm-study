package StudyFiles.DataStructures.P11866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static List<Integer> answerArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P11866/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answerArray = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            count++;
            if(count == K) {
                count = 0;
                answerArray.add(temp);
                continue;
            }
            q.add(temp);
        }

        sb.append("<");
        for (int i = 0; i < answerArray.size(); i++) {
            if(i == answerArray.size() - 1) {
                sb.append(answerArray.get(i));
                break;
            }
            sb.append(answerArray.get(i)).append(", ");
        }
        sb.append(">");

        System.out.print(sb);
    }
}
