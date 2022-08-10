package StudyFiles.Recursion.P10870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Recursion/P10870/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 0) System.out.println(0);
        else if(N == 1) System.out.println(1);
        else {
            recursion(0, 0, 1);
        }
    }
    static void recursion(int count, int a, int b) {
        if(count >= N - 1) System.out.println(b);
        else recursion(count + 1, b, a + b);
    }
}
