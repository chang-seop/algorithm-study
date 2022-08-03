package SamsungAlgorithmStudy.DAY04.P1837;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//소수(Prime) 구하기 + bigInt 활용방법
public class Main {
    static int MAX = 1000000;
    static boolean[] isNotPrime;
    static char[] P;
    static int K;
    static List<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY04/P1837/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K;
        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[MAX + 1];
        for (int i = 2; i < MAX + 1; i++) {
            if(!isNotPrime[i]) { //소수
                primes.add(i);
                for (int j = i * 2; j < MAX + 1; j += i) { //배수들
                    isNotPrime[j] = true;
                }
            }
        }

        for(int prime : primes) {
            if(prime >= K) {
                break;
            }
            if(checkIsBad(prime)) {
                System.out.println("BAD" + " " + prime);

                return;
            }
        }
        System.out.println("GOOD");
    }
    static boolean checkIsBad(int x) { // bigint P를 x로 나눈 나머지의 값을 검사
        int ret = 0;
        for (int i = 0; i < P.length; i++) {
            ret = (ret * 10 + (P[i] - '0')) % x;
        }
        if(ret == 0) {
            return true;
        } else {
            return false;
        }
    }
}

