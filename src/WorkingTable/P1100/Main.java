package WorkingTable.P1100;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1100/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int i = 0; i < 4; i++) {
            String N = br.readLine();
            for (int j = 1; j <= 8; j++) {
                if(N.charAt(j - 1) == 'F' && j % 2 == 1) count++;
            }
            N = br.readLine();
            for (int j = 1; j <= 8; j++) {
                if(N.charAt(j - 1) == 'F' && j % 2 == 0) count++;
            }
        }

        System.out.println(count);
    }
}
