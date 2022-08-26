package WorkingTable.P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<ArrayN> nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nArray = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            nArray.add(new ArrayN(first, last, last - first));
        }

        // center 기준으로 오름차순 정렬
        Collections.sort(nArray);

        long firstTemp = Long.MAX_VALUE, lastTemp = 0;
        int count = 0;
        for(ArrayN i : nArray) {
            if(firstTemp > i.first || lastTemp < i.last) {
                firstTemp = i.first;
                lastTemp = i.last;
                count++;
            }
        }
    }
}
class ArrayN implements Comparable<ArrayN>{
    int first;
    int last;
    int center;

    public ArrayN(int first, int last, int center) {
        this.first = first;
        this.last = last;
        this.center = center;
    }

    @Override
    public int compareTo(ArrayN o) {
        if(this.center == o.center) {
            return this.first - o.first;
        } else return this.center - o.center;
    }

    @Override
    public String toString() {
        return "ArrayN{" +
                "first=" + first +
                ", last=" + last +
                ", center=" + center +
                '}';
    }
}
