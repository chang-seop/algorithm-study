package StudyFiles.DynamicProgramming.P16400;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> nList;
    public static final int MAX = 40001;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DynamicProgramming/P16400/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];
        // 에라토스테네스의 체
        nList = getPrimeList(n);
        // DP
        dp[0] = 1;
        for (Integer integer : nList) { // 2
            for (int i = integer; i <= n; i++) {
                int temp = i - integer;
                dp[i] = (dp[i] + dp[i - integer]) % 123456789;
                System.out.print("|i = " + i + " dp[i] = " + dp[i] + " temp = " + temp + "| ");
            }
            System.out.println();
        }
        /*
        점화식 출력
        |i = 2 dp[i] = 1 temp = 0| |i = 3 dp[i] = 0 temp = 1| |i = 4 dp[i] = 1 temp = 2| |i = 5 dp[i] = 0 temp = 3| |i = 6 dp[i] = 1 temp = 4| |i = 7 dp[i] = 0 temp = 5| |i = 8 dp[i] = 1 temp = 6|
        |i = 3 dp[i] = 1 temp = 0| |i = 4 dp[i] = 1 temp = 1| |i = 5 dp[i] = 1 temp = 2| |i = 6 dp[i] = 2 temp = 3| |i = 7 dp[i] = 1 temp = 4| |i = 8 dp[i] = 2 temp = 5|
        |i = 5 dp[i] = 2 temp = 0| |i = 6 dp[i] = 2 temp = 1| |i = 7 dp[i] = 2 temp = 2| |i = 8 dp[i] = 3 temp = 3|
        |i = 7 dp[i] = 3 temp = 0| |i = 8 dp[i] = 3 temp = 1|
         */
    }

    private static List<Integer> getPrimeList(int n) {
        boolean[] primeArray = new boolean[n + 1];
        primeArray[0] = primeArray[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(primeArray[i]) continue;
            for (int j = i * i; j <= n; j++) {
                if(j % i == 0) primeArray[j] = true;
            }
        }
        return booleanArrayToIntegerList(n, primeArray);
    }

    private static List<Integer> booleanArrayToIntegerList(int n, boolean[] primeArray) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(!primeArray[i]) primeList.add(i);
        }
        return primeList;
    }
}
