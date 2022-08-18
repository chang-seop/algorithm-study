package StudyFiles.Sort.P1181;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;
    static List<String> nArray;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P1181/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArray = new ArrayList<>();

        // 입력
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if(!nArray.contains(temp))  { // 값이 이미 있을 경우 무시
                nArray.add(temp);
            }
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) > o2.charAt(i)) return 1;
                        else if(o1.charAt(i) < o2.charAt(i)) return -1;
                    }
                    return -1;
                } else return o1.length() - o2.length();
            }
        };
        Collections.sort(nArray, comp);

        // 출력
        for (int i = 0; i < nArray.size(); i++) {
            System.out.println(nArray.get(i));
        }
    }
}
