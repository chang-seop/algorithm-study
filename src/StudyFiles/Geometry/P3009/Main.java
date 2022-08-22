package StudyFiles.Geometry.P3009;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x1, y1, x2, y2, x3, y3;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Geometry/P3009/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        int X = 0, Y = 0;

        if(x1 == x2) {
            X = x3;
        } else if(x1 == x3) {
            X = x2;
        } else if(x2 == x3) {
            X = x1;
        }

        if(y1 == y2) {
            Y = y3;
        } else if(y1 == y3) {
            Y = y2;
        } else if(y2 == y3) {
            Y = y1;
        }

        System.out.println(X + " " + Y);
    }
}
