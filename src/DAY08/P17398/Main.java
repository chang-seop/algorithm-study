package DAY08.P17398;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, Q, X, Y;
    static long sum;
    static int arrQ[];
    static boolean chk[]; // 처음 넣을 간선인지 아닌지 체크
    static long cnt[];
    static int par[];
    static Edge edges[];

    static int find(int n) {
        if (par[n] == n)    return n;
        return par[n] = find(par[n]);
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA == findB)
            return;
        sum += (1L * cnt[findA] * cnt[findB]);
        cnt[findB] += cnt[findA];
        par[findA] = findB;
    }
    static class Edge {
        int a, b;
        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        sum = 0;
        arrQ = new int[Q + 1];
        chk = new boolean[M + 1];
        cnt = new long[N + 1];
        par = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            par[i] = i;
            cnt[i] = 1; // 처음 1로초기화
        }

        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            edges[m] = new Edge(X, Y);
        }

        Arrays.fill(chk, true);
        for (int i = 1; i <= Q; i++) { // Q입력
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken()); // arrQ에 1번부터 Q의 정보 입력
            arrQ[i] = q;
            chk[q] = false; //제거 처리
        }

        for (int i = 1; i <= M; i++) {
            if (chk[i] == true) { //마지막까지 제거되지 않은 간선이면 초기 union
                int A = edges[i].a;
                int B = edges[i].b;
                union(A, B);
            }
        }
        long temp = sum;

        // Q를 마지막부터 꺼내면서 union하고 계산
        for (int i = Q; i >= 1; i--) {
            int N = arrQ[i];
            int A = edges[N].a;
            int B = edges[N].b;
            union(A, B);
        }
        System.out.println(sum - temp);
    }
}