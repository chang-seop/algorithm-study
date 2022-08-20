package StudyFiles.SetsAndMaps.P1269;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static int[] aArray, bArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SetsAndMaps/P1269/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        aArray = new int[A];
        bArray = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aArray[i] = Integer.parseInt(st.nextToken());
            hashMap.put(aArray[i], 0);
        }

        int count1 = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bArray[i] = Integer.parseInt(st.nextToken());
            //B - A 구하기
            if(!hashMap.containsKey(bArray[i])) {
                count1++;
            }
            // 중복된 값은 bArray 로 덮어 씌우기
            hashMap.put(bArray[i], 1);
        }

        int count2 = 0;
        for (int i = 0; i < A; i++) {
            //A - B 구하기
            if(hashMap.get(aArray[i]) != 1) {
                count2++;
            }
        }

        System.out.print(count1 + count2);
    }
}
