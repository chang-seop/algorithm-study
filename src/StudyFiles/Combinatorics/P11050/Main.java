package StudyFiles.Combinatorics.P11050;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Combinatorics/P11050/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //이항 계수 -> 조합 N! / K! * N-K!
        System.out.println(factorial(N) / (factorial(K) * factorial(N-K)));
    }
    static int factorial(int N) {
        int sum = 1;
        while(N != 0) {
            sum *= N--;
        }
        return sum;
    }
}
