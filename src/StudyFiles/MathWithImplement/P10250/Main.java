package StudyFiles.MathWithImplement.P10250;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, H, W, N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P10250/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int result = N, count = 1;
            while(result > H) { // 남은 result = 앞에 숫자
                count++; //뒤에 숫자
                result = result - H;
            }

            String value = Integer.toString(count);
            if(count < 10) { // 99층 또는 99호실까지 있으니 세자리 숫자 무시
                value = '0' + value;
            }

            value = result + value;

            System.out.println(value);
        }
    }
}
