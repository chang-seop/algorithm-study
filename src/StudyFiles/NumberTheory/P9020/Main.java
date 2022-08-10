package StudyFiles.NumberTheory.P9020;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int T, N;
    static int[] dp;
    static List<Temp> abList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/NumberTheory/P9020/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        dp[0] = dp[1] = 1;
        // 문제에 주어진 최대 값 만큼 소수 만들기
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if(dp[i] != 0) continue;
            for (int j = i * i; j <= 10000; j += i) {
                if(dp[j] == 0) dp[j]++;
            }
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            abList = new ArrayList<Temp>();

            // 두 소수의 차이가 가장 작은것 ##
            for (int j = 2; j < N; j++) {
                if(dp[j] == 1) continue;

                int high = N;
                int low = 2;
                int mid = 0;
                int compare = 0;

                while(low <= high) {
                    mid = (high + low) / 2;
                    if(dp[mid] == 0 && mid + j == N) {
                        abList.add(new Temp(j, mid, mid - j));
                    }
                    if(mid + j > N) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }

            Collections.sort(abList);

            System.out.println(abList.get(0).toString());
        }
    }
}
class Temp implements Comparable<Temp>{
    int a;
    int b;
    int at;
    Temp(int a, int b, int at) {
        this.a = a;
        this.b = b;
        this.at = at;
    }

    @Override
    public int compareTo(Temp o) {
        return (this.at * -1) - o.at;
    }

    @Override
    public String toString() {
        if(a >= b) return b + " " + a;
        else return a + " " + b;
    }
}
