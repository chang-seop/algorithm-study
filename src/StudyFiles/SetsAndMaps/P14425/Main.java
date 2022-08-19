package StudyFiles.SetsAndMaps.P14425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M, S;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SetsAndMaps/P14425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            hashMap.put(i, br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();

            for(String a : hashMap.values()) {
                if(temp.equals(a)) count++;
            }
        }
        System.out.println(count);
    }
}
