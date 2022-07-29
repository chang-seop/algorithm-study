package StudyFiles.P2231;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static String nString;
    static int nInt;
    static int result;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P2231/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nInt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.println(result);

        pq.add(nInt);

        //bfs
        while(!pq.isEmpty()) {
            // 1. 큐에서 가져오기
            // 2. 목적지 인가?
            // 3. 연결된 곳 순회하기
            // 4. 갈 수 있는가?
            // 5. 체크인
            // 6. 큐에 넣기
        }
    }

    static int deComPosition(String n) {
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        return sum;
    }
}
