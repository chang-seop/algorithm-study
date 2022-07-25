package StudyFiles.P2525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream( "src/StudyFiles/P2525/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        B += C;
        if(B >= 60) {
            int tmp = B / 60;
            B %= 60;
            A += tmp;
            if(A >= 24) A %= 24;
        }
        System.out.println(A + " " + B);
    }
}
