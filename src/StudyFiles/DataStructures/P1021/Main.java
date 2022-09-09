package StudyFiles.DataStructures.P1021;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P1021/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Integer> compareQ = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            compareQ.add(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq1.addLast(i);
            dq2.addLast(i);
        }

        int count = 0;
        while(!compareQ.isEmpty()) {
            int compare = compareQ.poll();
            int qCount1 = 0;
            int qCount2 = 0;
            while(true) {
                // 탈출 조건
                if(compare == dq1.peekFirst()) {
                    dq1.pollFirst();
                    break;
                } else {
                    dq1.addLast(dq1.pollFirst());
                    qCount1++;
                }
            }
            while(true) {
                // 탈출 조건
                if(compare == dq2.peekFirst()) {
                    dq2.pollFirst();
                    break;
                } else {
                    dq2.addFirst(dq2.pollLast());
                    qCount2++;
                }
            }
            if(qCount1 > qCount2) {
                count += qCount2;
                dq1 = new LinkedList<>(dq2);
            }
            else {
                count += qCount1;
                dq2 = new LinkedList<>(dq1);
            }
        }
        System.out.print(count);
    }
}
