package StudyFiles.CumulativeSum.P11659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IndexTree {
    static int N, M, S;
    static int[] nArray;
    static int[] indexTree;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/CumulativeSum/P11659/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인덱스 트리 배열 할당
        S = 1;
        while (S < N) {
            S *= 2;
        }
        indexTree = new int[2 * S]; // 더미를 생각 해야 돼서 + 1 안함 ( index 0 )
        nArray = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        initIndexTree();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(query(1, S, 1, a, b));
        }
    }
    static void initIndexTree() {
        // Leaf 에 값 반영
        for (int i = 0; i < N; i++) { // Leaf 노드에 채우기
            indexTree[S + i] = nArray[i];
        }
        // 내부 노드 채우기
        for (int i = S - 1; i > 0; i--) {
            indexTree[i] = indexTree[i * 2] + indexTree[i * 2 + 1];
        }
    }

    static int query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관이 없음 -> 결과에 영향이 없는 값 return (1번 케이스)
        if(queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return (2번 케이스)
        else if(queryLeft <= left && right <= queryRight) {
            return indexTree[node]; // node - > 실제 트리에 있는 값
        }
        // 판단불가, *자식에게 위임*, 자식에서 올라온 합을 return (3번 케이스)
        else {
            int mid = (left + right) / 2;
            int resultLeft = query(left, mid, node * 2, queryLeft, queryRight); // 왼쪽 노드
            int resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight); // 오른쪽 노드
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, int target, int diff) {
        // 연관없음
        if(target < left || target < right) {

        }
        // 연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        else {
            indexTree[node] += diff;
            if(left != right) { //만약, 다르지 않으면 범위 내 target 을 찾음.
                // 내부 노드 update
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff); // 왼쪽 노드
                update(mid + 1, right, node * 2 + 1, target, diff); // 오른쪽 노드
            }
        }
    }
}
