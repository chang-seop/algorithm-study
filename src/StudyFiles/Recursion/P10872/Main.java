package StudyFiles.Recursion.P10872;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Recursion/P10872/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(recursion(1));
    }
    static int recursion(int count) {
        if(count >= N) return count;
        else return count * recursion(count + 1);
    }
}
