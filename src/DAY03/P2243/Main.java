package DAY03.P2243;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int A, B, C, S;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P2243/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        S = 1;
        while(S < N) {
            S *= 2;
        }
        tree = new int[S];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            if(A == 2) {
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                update(1, S, 1, B, C);
            } else if(A == 1) {
                B = Integer.parseInt(st.nextToken());
                int index = query(1, S, 1, B);
                update(1, S, 1, index, index -1);
            }
        }
    }
    static int query(int left, int right, int node, int count) {
        // 1. Leaf 에 도착했을때 -> 사탕 번호 반환
        if(left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;
            // 2. 왼쪽 >= count -> 왼쪽으로 이동
            if(tree[node * 2] >= count) {
                return query(left, mid, node * 2, count);
            }
            // 3. 왼쪽 < count -> 오른쪽으로 이동
            else {
                count -= tree[node * 2];
                return query(mid + 1, right, node * 2 + 1, count);
            }
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
}
