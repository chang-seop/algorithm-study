package StudyFiles.Sort.P18870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] integerArray, keys;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P18870/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>(); //해시 맵
        integerArray = new int[N];
        keys = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            integerArray[i] = keys[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(integerArray);

        int count = 0;
        for (int i : integerArray) {
            if(!hashMap.containsKey(i)) {
                hashMap.put(i, count++);
            }
        }

        for(int i : keys) sb.append(hashMap.get(i)).append(" ");
        System.out.print(sb);
    }
}