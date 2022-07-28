package DAY08.P3830;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] par;
    static long[] wei;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if( N ==0 && M==0) break;
            par = new int[N+1];
            wei = new long[N+1];
            for (int i = 1; i <= N; i++) {
                par[i]= i;
            }
            int a, b, w;
            char cmd;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken().charAt(0);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if(cmd == '!') {
                    w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                }
                else {
                    if(find(a) != find(b)) {
                        sb.append("UNKNOWN\n");
                    } else {
                        long diff =  wei[a] - wei[b];
                        sb.append(diff + "\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

    public static int find(int n) {
        if (par[n]==n) {
            return n;
        }
        int p = find(par[n]);
        wei[n] += wei[par[n]];
        par[n] = p;
        return p;
    }

    static void union(int a, int b, int w) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        wei[pa] = wei[b] - wei[a] + w;
        par[pa] = pb;
    }
}