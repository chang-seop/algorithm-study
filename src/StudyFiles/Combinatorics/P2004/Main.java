package StudyFiles.Combinatorics.P2004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Combinatorics/P2004/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 조합 N C M N 의 2와 5의 승수
        int set2 = two(N) - two(N - M) - two(M);
        int set5 = five(N) - five(N - M) - five(M);

        System.out.print(Math.min(set2, set5));

    }
    static int two (int n) {
        int count = 0;
        while(n >= 2) {
            count += n / 2;
            n /= 2;
        }
        return count;
    }

    static int five (int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
