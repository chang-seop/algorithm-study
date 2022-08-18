package StudyFiles.Sort.P18870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Hello> helloList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P18870/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        helloList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            helloList.add(new Hello(Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(helloList); // 오름차 순 정렬
        // N^2은 1,000,000 * 1,000,000 -> 시간 초과
        int ptr1 = 0;
        int ptr2 = 0;
        int count = 0;
        while(ptr2 < N && ptr1 < N) {
            if(ptr1 == N-1 && ptr2 == N-1) helloList.set(ptr1, new Hello(count, helloList.get(ptr1).count));
            if(ptr1 != ptr2) {
                if(helloList.get(ptr1).value != helloList.get(ptr2).value) {
                    helloList.set(ptr1, new Hello(count++, helloList.get(ptr1).count));
                    ptr1++;
                } else {
                    helloList.set(ptr1, new Hello(count, helloList.get(ptr1).count));
                    ptr1++;
                }
            } else {
                ptr2++;
            }
        }

        Comparator<Hello> comp = new Comparator<Hello>() {
            @Override
            public int compare(Hello o1, Hello o2) {
                return o1.count - o2.count;
            }
        };
        Collections.sort(helloList, comp); // 초기 count로 오름차 순 정렬

        for (int i = 0; i < N; i++) {
            sb.append(helloList.get(i).value).append(" ");
        }
        System.out.println(sb);
    }
}
class Hello implements Comparable<Hello>{
    int value;
    int count;
    Hello(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Hello o) {
        return this.value - o.value;
    }
}
