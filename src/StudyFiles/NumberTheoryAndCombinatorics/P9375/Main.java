package StudyFiles.NumberTheoryAndCombinatorics.P9375;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int testCase1, testCase2;
    static List<String> keyList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheoryAndCombinatorics/P9375/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase1 = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        keyList = new ArrayList<>();

        //중복되는 옷은 입지 않는다.,
        for (int i = 0; i < testCase1; i++) {
            testCase2 = Integer.parseInt(br.readLine());
            hashMap.clear();
            for (int j = 0; j < testCase2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();
                if(!hashMap.containsKey(type)) {
                    hashMap.put(type, 1);
                } else {
                    hashMap.put(type, hashMap.get(type) + 1);
                }
            }
            //TestCase 1 : ab : 2 개 종류의 하나를 고르고 *  c : 3개 종류의 하나를 구한다
            int result = 1;
            for(int value : hashMap.values()) result *= (value + 1); // 입지 않는 경우를 고려 하여 + 1

            // 전체 옷을 안고르는 수 제거
            System.out.println(result - 1);
        }
    }
}
