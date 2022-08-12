package StudyFiles.BruteForceAlgorithm.P7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] nArray;
    static int[] ranks;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BruteForceAlgorithm/P7568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nArray = new int[N][2];
        ranks = new int[N];
        answer =new int[N];

        for (int i = 0; i < N; i++) ranks[i] = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nArray[i][0] = Integer.parseInt(st.nextToken()); // weight
            nArray[i][1] = Integer.parseInt(st.nextToken()); // height
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < nArray.length; j++) {
                if(i == j) continue;
                if(nArray[i][0] < nArray[j][0]) {
                    if(nArray[i][1] < nArray[j][1]) {
                        ranks[i]++;
                    }
                }
            }
        }
        for (int i : ranks) System.out.print(i + " ");
    }
}