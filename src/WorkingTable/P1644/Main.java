package WorkingTable.P1644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int[] primeCompare;
    static List<Integer> primeArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //최소 값인 1은 소수가 없으므로 제외
        if(N == 1) {
            System.out.println(0);
            return;
        }
        // N 만큼 소수 만들기
        primeCompare = new int[N + 1];
        primeArray = new ArrayList<>();

        // 소수 생성
        primeCompare[0] = primeCompare[1] = -1;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(primeCompare[i] == -1) continue;
            for (int j = i * i; j <= N; j += i) {
                primeCompare[j] = -1;
            }
        }

        // List 에 소수 넣기
        for (int i = 0; i <= N; i++) {
            if(primeCompare[i] != -1) primeArray.add(i);
        }

        // 소수를 가지고 연속된 소수의 합 비교 -> 슬라이딩 윈도우
        int length = primeArray.size() - 1;
        int start = 0;
        int end = 0;
        int count = 0;
        int sum = primeArray.get(start);
        while(start <= end) {
            if(sum < N) {
                if(end + 1 > length) break;
                sum += primeArray.get(++end);
            } else if(sum > N) {
                if(start + 1 > length) break;
                sum -= primeArray.get(start++);
            }

            if(sum == N) {
                count++;
                if(start + 1 > length) break;
                sum -= primeArray.get(start++);
            }
        }

        System.out.print(count);
    }
}
