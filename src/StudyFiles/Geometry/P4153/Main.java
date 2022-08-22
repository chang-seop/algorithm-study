package StudyFiles.Geometry.P4153;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Geometry/P4153/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        a = b = c = -1;

        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 탈출 조건
            if(a == 0 && b == 0 && c == 0) break;

            // 직각 삼각형 밑변^2 + 높이^2 == 빗변^2
            if(a > b && a > c) {
                if((b * b) + (c * c) == (a * a)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if(b > a && b > c) {
                if((a * a) + (c * c) == (b * b)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if(c > a && c > b) {
                if((a * a) + (b * b) == (c * c)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }
}
