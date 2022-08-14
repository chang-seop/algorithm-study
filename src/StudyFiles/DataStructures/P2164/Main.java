package StudyFiles.DataStructures.P2164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P2164/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        Integer answer = 0;
        while(true) {
            answer = queue.poll(); // 일단 한번 버린다
            if(queue.isEmpty()) {
                break;
            }
            Integer temp = queue.poll();
            queue.add(temp);
        }
        System.out.println(answer);
    }
}
