package WorkingTable.P11653;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P11653/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int temp = N;
        int i = 2;
        while(true) {
            if(temp == 0 || i > Math.sqrt(N)) break;
            else if(temp % i == 0) {
                System.out.println(i);
                temp /= i;
                i = 1;
            }
            i++;
        }
    }
}
