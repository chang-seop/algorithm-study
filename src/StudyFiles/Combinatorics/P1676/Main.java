package StudyFiles.Combinatorics.P1676;

import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Combinatorics/P1676/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 0;
        while(N >= 5) {
            count += N / 5;
            N /= 5;
        }
        System.out.print(count);
    }
}
