package StudyFiles.SetsAndMaps.P1764;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<String> answerList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SetsAndMaps/P1764/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        answerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            if(hashSet.contains(temp)) {
                answerList.add(temp);
                count++;
            }
        }

        // 사전 순 -> 오름차 순
        Collections.sort(answerList);

        sb.append(count).append("\n");
        for(String answer : answerList)  {
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
