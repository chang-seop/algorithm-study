package WorkingTable.P1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr1 = { // 처음 W
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };
    static char[][] arr2 = { // 처음 B
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };
    static int Y, X;
    static char[][] nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1018/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nArray = new char[Y][X];

        for (int y = 0; y < Y; y++) {
            String temp = br.readLine();
            for (int x = 0; x < X; x++) {
                nArray[y][x] = temp.charAt(x);
            }
        }

        int count = 0;
        int arrY = 0, arrX = 0;
        boolean visited1 = false, visited2 = false;

        if(nArray[0][0] == 'W') {
            for (int y = 0; y < Y ; y++, arrY++) {
                for (int x = 0; x < X; x++, arrX++) {
                    if(nArray[y][x] != arr1[arrY][arrX]) {
                        visited1 = true;
                    }
                }
                if(arrY == 8 - 1) {
                    arrY = 0;
                    arrX = 0;
                    if(visited1) {
                        count++;
                        visited1 = false;
                    }
                }
                arrX = 0;
            }
        } else {
            for (int y = 0; y < Y ; y++, arrY++) {
                for (int x = 0; x < 8; x++) {

                }
            }
        }
        System.out.println(count);
    }
}
