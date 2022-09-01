package StudyFiles.NumberTheory.P1934;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유클리드 호제법
public class Main {
    static int T, A, B;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheory/P1934/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            System.out.println(A * B / gcd(A, B)); // 최소 공배수
        }

    }
    static int gcd(int a, int b) { // 최대 공약수
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
