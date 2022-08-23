package WorkingTable.P2981;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[] nArray;
    static List<Integer> answerArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P2981/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        answerArray = new ArrayList<>();
        for (int i = 0; i < N; i++) nArray[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            String[] temp = gcd(nArray[i - 1], nArray[i], "").split(" ");
            for(String a : temp) {
                if(Integer.parseInt(a) == 0 || Integer.parseInt(a) == 1) continue;
                answerArray.add(Integer.parseInt(a));
            }
        }

        Collections.sort(answerArray);

        for(int i : answerArray) System.out.println(i);

        int count = 1;
        for (int i = 1; i < answerArray.size(); i++) {
            if(answerArray.get(i - 1) == answerArray.get(i)) {
                count++;
            }

            if(count == N - 1) {
                sb.append(answerArray.get(i - 1)).append(" ");
                count = 1;
            }
        }

        System.out.print(sb);
    }
    static String gcd(int a, int b, String temp) {
        if(b == 0){
            return temp;
        } else return gcd(b, a%b, temp + Integer.toString(a % b) + " ");
    }
}