package StudyFiles.MathWithImplement.P1076;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/MathWithImplement/P1076/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        boolean visited = false;
        for (int i = 0; i < 2; i++) {
            int a = registerCompare(br.readLine());
            if(visited && a == 0) {
                System.out.println(0);
                return;
            }
            if(i == 0 && a == 0) {
                visited = true;
                continue;
            }
            sb.append(a);
        }

        int c = registerCompare(br.readLine());

        for (int i = 0; i < c; i++) {
            sb.append("0");
        }
        sb.append("\n");

        System.out.print(sb);
    }

    static int registerCompare(String temp) {
        if(temp.equals("black")) return 0;
        else if(temp.equals("brown")) return 1;
        else if(temp.equals("red")) return 2;
        else if(temp.equals("orange")) return 3;
        else if(temp.equals("yellow")) return 4;
        else if(temp.equals("green")) return 5;
        else if(temp.equals("blue")) return 6;
        else if(temp.equals("violet")) return 7;
        else if(temp.equals("grey")) return 8;
        else return 9;
    }
}
