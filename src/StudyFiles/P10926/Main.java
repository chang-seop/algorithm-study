package StudyFiles.P10926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P10926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = br.readLine();
        answer += "??!";

        System.out.println(answer);
    }
}
