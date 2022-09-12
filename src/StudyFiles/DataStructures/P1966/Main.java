package StudyFiles.DataStructures.P1966;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int testCase1, testCase2, N, M;
    static Integer[] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        testCase1 = Integer.parseInt(br.readLine());

        Queue<Point> q = new LinkedList<>();

        while(testCase1-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            q.clear();
            nArray = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nArray[i] = Integer.parseInt(st.nextToken());
                q.add(new Point(i, nArray[i]));
            }

            Arrays.sort(nArray, Comparator.reverseOrder());

            int count = 0, max = 0;
            int ptr = 0;
            while(!q.isEmpty()) {
                if(ptr == nArray.length) {
                    break;
                }
                Point temp = q.poll();
                int compare = nArray[ptr];

                if(temp.address == M && temp.priority == compare) {
                    count++;
                    break;
                }

                if(temp.priority == compare) {
                    ptr++;
                    count++;
                } else {
                    q.add(temp);
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
class Point implements Comparable<Point>{
    int address;
    int priority;

    public Point(int address, int priority) {
        this.address = address;
        this.priority = priority;
    }

    @Override
    public int compareTo(Point o) {
        return o.priority - this.priority;
    }
}
