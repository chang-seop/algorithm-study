package StudyFiles.Geometry.P3053;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R;
    final static double PI = Math.PI;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Geometry/P3053/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());

        // 유클리드 기하학
        double piR = PI * (R * R);
        // 택시 기하학
        double piTaxi = (R * R) + (R * R);
        System.out.printf("%.6f%n", piR);
        System.out.printf("%.6f%n", piTaxi);
    }
}
