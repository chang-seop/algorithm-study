package StudyFiles.SegmentTree.P11505;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, S;
    static long[] tree, nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SegmentTree/P11505/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nArray = new long[N];
        for (int i = 0; i < N; i++) {
            nArray[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while(S < N) {
            S *= 2;
        }
        tree = new long[S * 2]; // 더미 추가
        for (int i = 1; i < S * 2; i++) {
            tree[i] = 1; // 1로 초기화
        }

        init();

        for (int i = 0; i < M + K; i++) {
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == 1) {
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(0, S, 1, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static void init() {
        for (int i = 0; i < N; i++) {
            tree[i + S] = nArray[i];
        }
        for (int i = S - 1; i > 0; i--) {
            tree[i] = (tree[i * 2] * tree[(i * 2) + 1]) % 1000000007;
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관 없음
        if(queryRight < left || right < queryLeft) {
            return 1L; // 1을 리턴
        }

        // 판단 가능
        else if(queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        // 판단 불가, 자식에게 넘기기
        else {
            int mid = (left + right) / 2;
            long leftQuery = query(left, mid, node * 2, queryLeft, queryRight); // 왼쪽 자식 노드
            long rightQuery = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight); // 오른쪽 자식 노드
            return (leftQuery * rightQuery) % 1000000007;
        }
    }

    //바텀 업 방식
    static void update(int target, long value) {
        // leaf 노드에서 target 을 찾음
        int index = S + target - 1;
        // value 반영
        tree[index] = value;

        //Root 에 도달할 때 까지 부모에 값 반영
        index /= 2; // 부모노드로 이동
        while(index > 0) { // (더미를 제외한) 루트를 포함한 모든 상황
            tree[index] = (tree[index * 2] * tree[(index * 2) + 1]) % 1000000007; //자식 노드 값을 곱한 후 부모 노드 값에 전달
            index /= 2;
        }
    }
}
