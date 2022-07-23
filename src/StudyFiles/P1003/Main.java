package StudyFiles.P1003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, zero, one;
    static int[] intArray;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P1003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        intArray = new int[42];
        for (int i = 0; i < 42; i++) {
            if (i == 0) intArray[i] = 1;
            else if (i == 1) intArray[i] = 1;
            else {
                intArray[i] = intArray[i - 1] + intArray[i - 2];
            }
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                System.out.println(1 + " " + 0);
            } else {
                zero = intArray[input] - intArray[input - 1];
                one = intArray[input + 1] - intArray[input];
                System.out.println(zero + " " + one);
            }
        }

    }
}
