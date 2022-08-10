package StudyFiles.MathWithImplement.P2480;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P2480/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if(A == B && A == C) { // A == B == C
            System.out.println(10000 + A * 1000);
        } else if(A == B || B == C) { // A == B 아니면 B == C
            System.out.println(1000 + B * 100);
        } else if(A == C){ // A == C
            System.out.println(1000 + A * 100);
        } else { //모두 다른 눈일 경우
            if(A > B) { // C > A > B
                if(C > A) System.out.println(C * 100);
                else System.out.println(A * 100);

            } else {
                if(C > B) System.out.println(C * 100);
                else System.out.println(B * 100);
            }
        }
    }
}
