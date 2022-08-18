package StudyFiles.Sort.P1427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String N;
    static List<Integer> nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P1427/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        nArray = new ArrayList<>();
        for (int i = 0; i < N.length(); i++) {
            nArray.add(N.charAt(i) - '0');
        }
        Collections.sort(nArray, Collections.reverseOrder());

        for (int i = 0; i < nArray.size(); i++) {
            System.out.print(nArray.get(i));
        }
    }
}
