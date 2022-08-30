package StudyFiles.GreedyAlgorithm.P1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String N;
    static List<Integer> opNumber;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GreedyAlgorithm/P1541/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = br.readLine();
        opNumber = new ArrayList<>();
        int answer = 0;
        // 식이 있는 경우
        if (N.contains("-") || N.contains("+")) {
            // + 부터
            st = new StringTokenizer(N, "-");
            while(st.hasMoreTokens()) {
                String temp = st.nextToken();
                if(temp.contains("+")) {
                    int sum = 0;
                    String[] tempArray = temp.split("[+]");
                    for (int i = 0; i < tempArray.length; i++) {
                        sum += Integer.parseInt(tempArray[i]);
                    }
                    opNumber.add(sum);
                } else opNumber.add(Integer.parseInt(temp));
            }
            answer = opNumber.get(0);
            for (int i = 1; i < opNumber.size(); i++) {
                answer -= opNumber.get(i);
            }
            System.out.println(answer);
        }
        // 없는 경우
        else System.out.println(Integer.parseInt(N));
    }
}
