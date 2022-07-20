package DAY03.P11279;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P11279/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();

        for (int n = 0; n < N; n++) {
            int X = Integer.parseInt(br.readLine());
            if(X == 0) {
                System.out.println(pq.poll());
            } else {
                pq.add(X);
            }
        }

    }
}
