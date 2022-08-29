package WorkingTable.P1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1541/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> number = new ArrayList<>();
        String operation = "+";

        N = br.readLine();
        // 분리
        String temp1 = "";
        for (int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '-' || N.charAt(i) == '+') {
                operation += (N.charAt(i));
                number.add(Integer.parseInt(temp1));
                temp1 = "";
            }
            else temp1 += N.charAt(i);
        }
        // 마지막 수
        number.add(Integer.parseInt(temp1));


        int plus = 0,  i = 0;
        while(i < operation.length()) {
            if(operation.charAt(i) == '+') {
                plus += number.get(i);
                plus += number.get(i + 1);
                number.set(i, 0);
                number.set(i + 1, 0);
            }
            i++;
        }

        i = 0;
        int minus = plus;
        while(i < operation.length()) {
            if(operation.charAt(i) == '-') {
                minus -= number.get(i);
                minus -= number.get(i + 1);
            }
            i++;
        }
        System.out.println(plus);
        System.out.println(minus);
        System.out.println(plus - minus);
    }
}
