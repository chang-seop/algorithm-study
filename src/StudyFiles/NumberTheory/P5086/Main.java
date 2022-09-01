package StudyFiles.NumberTheory.P5086;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A = -1, B = -1;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheory/P5086/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 탈출 조건
            if(A == 0 && B == 0) {
                break;
            }

            if(A % B != 0) { // factor, neither
                if(B % A == 0) System.out.println("factor");
                else System.out.println("neither");
            } else System.out.println("multiple");
        }
    }
}
