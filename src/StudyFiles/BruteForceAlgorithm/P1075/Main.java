package StudyFiles.BruteForceAlgorithm.P1075;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, F;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BruteForceAlgorithm/P1075/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());

        int answerA = 0, answerB = 0;
        for (int i = 0; i < 10; i++) {
            boolean visited = false;
            for (int j = 0; j < 10; j++) {
                if((((((N / 100) * 10) + i) * 10) + j) % F == 0) {
                    answerA = i;
                    answerB = j;
                    visited = true;
                    break;
                }
            }
            if(visited) break;
        }

        System.out.println(answerA + "" + answerB);
    }
}
