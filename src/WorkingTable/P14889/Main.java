package WorkingTable.P14889;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P14889/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(min);
    }
    static void dfs(int dy, int dx, int count, int sum) {
        // 체크인
        visited[dy][dx] = visited[dx][dy] = true;
        // 목적지 인가?
        if(count == N / 2) {
            System.out.println(sum + " " + (map[dy][dx] + map[dx][dy]));
            min = Math.min(min, Math.abs((sum) - (map[dy][dx] + map[dx][dy])));
            System.out.println(min);
        } else {
            // 연결된 곳 순회
            for (int y = dy + 1; y < N; y++) {
                for (int x = dx + 1; x < N; x++) {
                    // 갈 수 있는가?
                    if(!visited[y][x] && !visited[x][y] && (map[y][x] != 0 && map[x][y] != 0)) {
                        dfs(y, x, count + 1, map[dy][dx] + map[dx][dy]);
                    }
                }
            }
        }
        // 체크 아웃
        visited[dy][dx] = visited[dx][dy] = false;
    }
}
