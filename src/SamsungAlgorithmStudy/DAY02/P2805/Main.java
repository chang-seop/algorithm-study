package SamsungAlgorithmStudy.DAY02.P2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int max;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY02/P2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            trees[n] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[n], max);
        }

        long start = 0;
        long end = max;
        long mid = 0;
        long result = 0;
        while(true) {  // while 시작 전에 검증
            mid = (start + end) / 2;
            long sum = calc(mid);
            // sum == M -> 정답, 탈출
            if(sum == M) {
                result = mid;
                break;
            }
            // sum < M -> mid -> end
            else if(sum < M) {
                end = mid - 1;
            } else { // sum > M -> mid -> s, 정답 후보
                result = mid;
                start = mid + 1;
            }
            //=======================================================
            if (start > end) { // 뒤집혔을 때 탈출문 ( while 비교 후에 검증 )
                break;
            }
        }
        System.out.println(result);
    }
    //각 나무의 길이 만큼 자르고 누적합 반환 함수
    static long calc(long value) {
        long result = 0;
        for (int i = 0; i < trees.length; i++) {
            int tree = trees[i];
            if (tree > value) {
                result += tree - value;
            }
        }
        return result;
    }
}
