package StudyFiles.CumulativeSum.P2559;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, S;
    static int[] nArray, indexTree;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/CumulativeSum/P2559/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;

        nArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        //인덱스 트리
        S = 1;
        while(S < N) {
            S *= 2;
        }
        indexTree = new int[S * 2];
        init();

        for (int i = 1; i <= N - K; i++) {
            max = Math.max(query(1, S, 1, i, i + K), max);
        }
        System.out.println(max);
    }
    static void init() {
        // 리프 노드 채우기
        for (int i = 0; i < N; i++) {
            indexTree[S + i] = nArray[i];
        }
        // 내부 노드 채우기
        for (int i = S - 1; i > 0; i--) {
            indexTree[i] = indexTree[i * 2] + indexTree[i * 2 + 1];
        }
    }

    static int query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관 없음
        if(queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능
        else if(queryLeft <= left && right <= queryRight) {
            return indexTree[node];
        }
        // 판단 불가
        else {
            int mid = (left + right) / 2;
            int resultLeft = query(left, mid, node * 2, queryLeft, queryRight); // 왼쪽노드
            int resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight); // 오른쪽 노드
            return resultLeft + resultRight;
        }
    }

}