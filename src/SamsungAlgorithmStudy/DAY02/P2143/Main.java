package SamsungAlgorithmStudy.DAY02.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long T;
    static int N, M;
    static long[] inputA, inputB;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY02/P2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine()); // 값
        N = Integer.parseInt(br.readLine()); // A 배열의 길이

        inputA = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            inputA[n] = Long.parseLong(st.nextToken()); // 입력받은 A 배열
        }

        M = Integer.parseInt(br.readLine()); // B 배열의 길이
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            inputB[m] = Long.parseLong(st.nextToken()); // 입력받은 B 배열
        }

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        //1. subA 구현 부분합
        for (int i = 0; i < N; i++) {
            long sum = inputA[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += inputA[j];
                subA.add(sum);
            }
        }

        //1. subB 구현 부분합
        for (int i = 0; i< M; i++) {
            long sum = inputB[i];
            subB.add(sum);
            for (int j = i+ 1; j < M; j++) {
                sum = sum + inputB[j];
                subB.add(sum);
            }
        }

        //2. subA, subB 정렬
        subA.sort(Comparator.naturalOrder()); // 오름차순
        subB.sort(Comparator.reverseOrder()); // 내림차순

        //3. 2 Pointer
        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while(true) {
            long currentA = subA.get(ptA);
            long target = T - currentA; // target -> 찾고싶은 수 - 현재 A의 숫자
            //currentB == target -> subA, subB 같은 수 개수 체크 -> 답 구하기, ptA+ ptB+
            if(subB.get(ptB) == target) { // subB.get(ptrB) -> currentB
                long countA = 0;
                long countB = 0;
                while(ptA < subA.size() && subA.get(ptA) == currentA) {
                    countA++;
                    ptA++;
                }
                while(ptB < subB.size() && subB.get(ptB) == target) {
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            //currentB > target -> ptB++
            else if(subB.get(ptB) > target) {
                ptB++;
            }
            //currentB < target -> ptA++
            else {
                ptA++;
            }
            //탈출 조건
            if(ptA == subA.size() || ptB == subB.size()) {
                break;
            }
        }
        System.out.println(result);
    }
}
