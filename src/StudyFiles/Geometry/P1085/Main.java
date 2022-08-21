package StudyFiles.Geometry.P1085;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, W, H;
    static double min = Double.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Geometry/P1085/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 0, 0 위치
        int x1 = 0, y1 = 0;

        // 직사각형의 경계 4 곳
        // 왼쪽 0, Y
        double left = Math.sqrt((x1 - X) * (x1 - X));
        // 위 X, H
        double top = Math.sqrt(((H - Y) * (H - Y)));
        // 오른쪽 W, Y
        double right = Math.sqrt(((W - X) * (W - X)));
        // 밑 X, 0
        double bottom = Math.sqrt(((y1 - Y) * (y1 - Y)));

        min = Math.min(min, left);
        min = Math.min(min, top);
        min = Math.min(min, right);
        min = Math.min(min, bottom);

        System.out.println(Math.round(min));
    }
}
