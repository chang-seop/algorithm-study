package StudyFiles.Hard.Recursive.P2447;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 별찍기 - 10 재귀 함수로 풀기....
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Hard/Recursive/P2447/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                recursive(y, x, N);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void recursive(int y, int x, int n) {
        if((y / n) % 3 == 1 && (x / n) % 3 == 1) {
            // (1, 1) (1, 4) (1, 7) ...
            // (y % 3 == 1) && (x % 3 == 1)

            // 그리고 (3, 3) (3, 4) (3, 5), (4, 3), (4, 4) (4, 5) (5, 3),(5, 4), (5, 5) ...
            // ((y / n(3, 9, 27..)) % 3 == 1) && ((x / n(3, 9, 27..)) % 3 == 1)
            sb.append(' ');
        } else {
            if(n / 3 == 0) {
                sb.append('*');
            } else{
                recursive(y, x, n / 3);
            }
        }
    }
}
