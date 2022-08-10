package StudyFiles.MathWithImplement.P10757;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String A, B;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P10757/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        int aLength = A.length() - 1;
        int bLength = B.length() - 1;
        int result = 0, resultTemp = 0, count = 0;
        String answer = "";

        if(aLength > bLength) {
            for (int i = bLength; i < aLength; i++) {
                B = "0" + B;
            }
        } else if(aLength < bLength) {
            for (int i = aLength; i < bLength; i++) {
                A = "0" + A;
            }
        }

        aLength = A.length() - 1;
        bLength = B.length() - 1;

        for (int i = aLength, j = bLength; i >= 0 && j >= 0; i--, j--) {
            result = stringToInt(A.charAt(i)) + stringToInt(B.charAt(j)) + count;
            if(i == 0) break;
            if(result >= 10) {
                count = result / 10;
                resultTemp = result % 10;
                answer = Integer.toString(resultTemp) + answer;
            } else {
                count = 0;
                answer = Integer.toString(result) + answer;
            }
        }
        answer = result + answer;

        System.out.println(answer);
    }
    static int stringToInt(char a) {
        return a - '0';
    }
}
