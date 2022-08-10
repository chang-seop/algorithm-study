package StudyFiles.Recursion.P11729;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Recursion/P11729/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb);
    }
    static void hanoi(int n, int from, int by, int temp) {
        if(n == 1) {
            sb.append(from + " " + temp).append("\n");
            ++count;
        } else {
            hanoi(n - 1, from, temp, by);
            sb.append(from + " " + temp).append("\n");
            ++count;
            hanoi(n - 1, by, from, temp);
        }
    }
}
