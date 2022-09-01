package StudyFiles.NumberTheory.P2609;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheory/P2609/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        System.out.println(gcd(A, B));
        System.out.println(A * B / gcd(A, B)); // 최소 공배수
    }
    static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        else return gcd(b, a % b); // 나머지
    }
}
