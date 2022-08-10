package WorkingTable.P2470;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P2470/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Temp> nTemps = new ArrayList<Temp>();
        N = Integer.parseInt(br.readLine());
        nArray = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             nArray[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차 순
        Arrays.sort(nArray);

        long max = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int high1 = N - 1, low1 = 0, ptr1 = 0;
            long temp1 = 0;
            int high2 = N - 1, low2 = 0, ptr2 = 0;
            long temp2 = 0;

            while(low1 <= high1) {
                ptr1 = (high1 + low1) / 2;
                temp1 = nArray[i] + nArray[ptr1];
                if((temp1 <= 0 && nArray[i] != nArray[ptr1])) {
                    nTemps.add(new Temp(nArray[i], nArray[ptr1], Math.max(temp1, max)));
                    low1 = ptr1 + 1;
                } else high1 = ptr1 - 1;
            }
        }

        Collections.sort(nTemps);
        System.out.println(nTemps.get(0).toString());
    }
}
class Temp implements Comparable<Temp>{
    long a;
    long b;
    long at;

    public Temp(long a, long b, long at) {
        this.a = a;
        this.b = b;
        this.at = at;
    }

    @Override
    public int compareTo(Temp o) {
        return (int)(this.at * -1) - (int)(o.at * -1);
    }

    @Override
    public String toString() {
        return Long.toString(this.a) + " " + Long.toString(this.b);
    }
}