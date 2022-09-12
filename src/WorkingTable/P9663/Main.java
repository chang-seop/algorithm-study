package WorkingTable.P9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, count;
    static boolean[][] visited, temp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        temp = new boolean[N][N];
        count = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                queenDfs(y, x);
            }
        }

        System.out.print(count);
    }

    static void queenDfs(int yIndex, int xIndex) {
        // 체크인
        temp = visited;
        for (int i = 0; i < N; i++) {
            visited[yIndex][i] = true;
            visited[i][xIndex] = true;
            for (int j = 0; j < N; j++) {

            }
        }

        int tempCount = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(visited[y][x]) {
                    tempCount++;
                } else break;
            }
        }

        //목적지 인가?
        if(tempCount == N * N) {
            count++;
        } else {
            // 연결된 곳 순회하기
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    // 갈 수 있는가?
                    if(!visited[y][x]) {
                        // 간다
                        queenDfs(y, x);
                    }
                }
            }
        }
        // 체크 아웃
        visited = temp;
    }
}
