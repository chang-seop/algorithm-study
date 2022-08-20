package StudyFiles.SetsAndMaps.P1620;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, test;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SetsAndMaps/P1620/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        test = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            hashMap1.put(i, input);
            hashMap2.put(input, i);
        }

        for (int i = 0; i < test; i++) {
            String temp = br.readLine();
            //스트링이 정수인지 단어인지 확인하는 String.matches 함수
            if(!temp.matches("[+-]?\\d*(\\.\\d+)?")) sb.append(hashMap2.get(temp)).append("\n");
            else sb.append(hashMap1.get(Integer.parseInt(temp))).append("\n");
        }
        System.out.print(sb);
    }
}
