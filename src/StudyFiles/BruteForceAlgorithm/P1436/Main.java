package StudyFiles.BruteForceAlgorithm.P1436;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BruteForceAlgorithm/P1436/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int value = 0, count = 0; // 0 부터 시작

        while(count != N) { // 카운트가 N을 만날때 까지
            int compare = ++value;
            while(compare != 0) { // 비교 값이 0을 만날때까지
                if(compare % 1000 == 666) { // 나머지가 666일 경우 카운트 + 1
                    count++;
                    break;
                }
                else compare /= 10; // 1의 자리 숫자를 뺌
            }
        }
        System.out.println(value);
    }
}
