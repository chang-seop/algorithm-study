package StudyFiles.MathWithImplement.P25304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P25304/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        X = Integer.parseInt(br.readLine());

        T = Integer.parseInt(br.readLine());
        int a, b, answer = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            answer += a * b;
        }
        if(answer == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
