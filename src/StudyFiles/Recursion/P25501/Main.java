package StudyFiles.Recursion.P25501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, recursionCount;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Recursion/P25501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String request = br.readLine();
            recursionCount = 0;

            sb.append(recursion(request, 0, request.length() - 1)).append(" ").append(recursionCount).append("\n");
        }

        System.out.print(sb);
    }
    static int recursion(String s, int left, int right) {
        recursionCount++;
        if(left >= right) return 1;
        else if(s.charAt(left) != s.charAt(right)) return 0;
        else return recursion(s, left + 1, right - 1);
    }
}
