package SamsungAlgorithmStudy.DAY06.P1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY06/P1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = makeSet(N);
        depth = makeSet(N);
        // 각 인덱스(=노드)는 자기 자신을 가리키고 있다

        for (int m = 0; m < M; m++) {
            int test, a, b;
            st = new StringTokenizer(br.readLine());
            test = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(test == 0) {
                union(a, b);
            } else if (test == 1) {
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    static int[] makeSet(int size) {
        int[] arr = new int[size + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[y] = x;
//        if(x != y) {
//            if(depth[x] < depth[y]) {
//                int tmp = x;
//                x = y;
//                y = tmp;
//            }
//            parent[y] = x;
//            if(depth[x] == depth[y]) depth[x]++;
//        }
    }
}
