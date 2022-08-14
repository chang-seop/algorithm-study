package StudyFiles.BackTracking.P14888;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nArray;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int operatorSize;
    static String operatorString = "0";
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BackTracking/P14888/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 부분
        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nArray[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < temp; j++) {
                if(i == 0) operatorString = operatorString + String.valueOf('+');
                else if(i == 1) operatorString = operatorString + String.valueOf('-');
                else if(i == 2) operatorString = operatorString + String.valueOf('*');
                else operatorString = operatorString + String.valueOf('/');
            }
        }

        operatorSize = operatorString.length();
        visited = new boolean[operatorSize + 1];

        dfs(0, 0, "");

        System.out.println(max);
        System.out.print(min);
    }
    static void dfs(int index, int count, String temp) {
        //체크 인
        visited[index] = true;
        //목적지인가
        if(count == operatorSize - 1) {
            //결과
            temp = "0" + temp;
            int sum = nArray[0];
            for (int i = 1; i < operatorSize; i++) {
                if(temp.charAt(i) == '+') sum += nArray[i];
                else if(temp.charAt(i) == '-') sum -= nArray[i];
                else if(temp.charAt(i) == '*') sum *= nArray[i];
                else if(temp.charAt(i) == '/') sum /= nArray[i];
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } else {
            //연결된 곳 순회하기
            for (int i = 1; i < operatorSize; i++) {
                //갈 수 있는가
                if(!visited[i]) {
                    dfs(i, count + 1, temp + operatorString.charAt(i));
                }
            }
        }
        //체크 아웃
        visited[index] = false;
    }
}
