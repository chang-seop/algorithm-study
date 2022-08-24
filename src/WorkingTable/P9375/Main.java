package WorkingTable.P9375;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int testCase1, testCase2;
    static List<String> keyList;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P9375/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase1 = Integer.parseInt(br.readLine());
        //중복되는 옷은 입지 않는다.
        HashMap<String, Integer> hashMap = new HashMap<>();
        dp = new int[31][31];
        keyList = new ArrayList<>();

        for (int i = 0; i < testCase1; i++) {
            testCase2 = Integer.parseInt(br.readLine());
            hashMap.clear();
            int count = 0;
            for (int j = 0; j < testCase2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();

                if(!hashMap.containsKey(type)) {
                    hashMap.put(type, testCase2);
                }
                else {
                    hashMap.put(type, hashMap.get(type) - 1);
                    count++;
                }
            }

            System.out.println(count);
            int answer = 0;
            for(int value : hashMap.values()) {
                answer += combination(testCase2, value);
            }
            System.out.println(answer);
        }
    }

    static int combination(int n, int k) {
        if(dp[n][k] > 0) {
            return dp[n][k];
        }

        if(n == k || k == 0) {
            return 1;
        }

        return dp[n][k] = combination(n - 1, k) + combination(n - 1, k - 1);
    }
}
