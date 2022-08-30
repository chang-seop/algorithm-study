package SamsungAlgorithmStudy.DAY03.P2042;

import java.io.*;
import java.util.StringTokenizer;

// Index Tree
public class Test {
    static long[] nums;
    static long[] tree;
    static int N, M, K, S;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy.DAY03/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine()); // Leaf 노드에 채우기
        }
        S = 1;
        while (S < N) {
            S *= 2; // n^2
        }
        tree = new long[2 * S]; // 더미를 생각 해야 돼서 + 1 안함 ( index 0 )
        initBUTP();

        for (int i = 0; i < M * K; i++) {
            int a, b, c2;
            long c1;
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // update
                c1 = Long.parseLong(st.nextToken());
                updateBU(b, c1);
            } else if (a == 2) {
                // query
                c2 = Integer.parseInt(st.nextToken());
                System.out.println(query(0, S, 1, b, c2));
            }
        }

    }

    //BU -> Button Up init || TP -> Top Down init
    static void initBUTP() {
        // S개념 중요!!
        // Leaf 에 값 반영
        for (int i = 0; i < N; i++) { // Leaf 노드에 채우기
            tree[S + i] = nums[i];
        }
        // 내부 노드 채움
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // TP -> Top Down query
    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관이 없음 -> 결과에 영향이 없는 값 return (1번 케이스)
        if(queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return (2번 케이스)
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node]; // node - > 실제 트리에 있는 값
        }
        // 판단불가, *자식에게 위임*, 자식에서 올라온 합을 return (3번 케이스)
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight); // -> 왼쪽 노드
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight); // -> 오른쪽 노드
            return resultLeft + resultRight;
        }
    }

    // TP -> Top Down update
    static void update(int left, int right, int node, int target, long diff) {
        // 연관없음
        if(target < left || right < target) {
            return;
        }
        // 연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        else {
            tree[node] += diff;
            if(left != right) { //만약, 다르지 않으면 범위 내 target 을 찾음.
                // 내부 노드
                int mid = (left + right) / 2;
                update(left, mid,node * 2, target, diff);
                update(mid+1, right, node * 2 + 1, target, diff);
            }
        }
    }

    //BU -> Bottom Up query
    static long queryBU(int queryLeft, int queryRight) {
        // Leaf 에서 left, right 설정
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;
        long sum = 0;
        while (left <= right) { // 구간이 하나일 때
            // 좌측 노드가 홀수이면 현재 노드 값 사용하고 한칸 옆으로
            if(left % 2 == 1) { // 홀수 : 오른쪽 자식 일때
                sum += tree[left++]; // 본인 값을 주기
            }
            // 우측 노드가 짝수면 현재 노드 값 사용하고 한칸 옆으로
            if(right % 2 == 0) {
                sum += tree[right--]; // 본인 값을 주기
            }
            // 좌측, 우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    //BU -> Bottom Up update
    static void updateBU(int target, long value) { // 인덱스 하나만  범위 갱신 X (targetLeft, targetRight)
        //Leaf에서 target을 찾음
        int index = S + target - 1;
        // value 반영
        tree[index] = value;
        //Root에 도달할 때 까지 부모에 값 반영
        index /= 2;
        while (index > 0) { // (더미를 제외한) 루트를 포함한 모든 상황
            tree[index] = tree[index * 2] + tree[index * 2 + 1]; //자식 노드 값을 더한 후 부모 노드 값에 전달
            index /= 2;
        }
    }
}
