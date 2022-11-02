package StudyFiles.GraphCircuit.BFS.P7569;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, H;
    static int[][][] map;
    static boolean[][][] visited;
    static int[] MY = {-1, 1, 0, 0, 0, 0};
    static int[] MX = {0, 0, -1, 1, 0, 0};
    static int[] MH = {0, 0, 0, 0, -1, 1};
    static int[][][] mapCount;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P7569/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][Y][X];
        visited = new boolean[H][Y][X];
        mapCount = new int[H][Y][X];
        Queue<Point> point = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < Y; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < X; x++) {
                    int value = Integer.parseInt(st.nextToken());
                    if(value == 1) {
                        // 큐에 넣기
                        point.add(new Point(h, y, x));
                        visited[h][y][x] = true;
                    }
                    map[h][y][x] = value;
                }
            }
        }

        //BFS
        while(!point.isEmpty()) {
            // 큐에서 꺼내오기
            Point tomato = point.poll();
            // 목적지인가?
            // 연결된 곳 순회 6방향 탐색
            for (int i = 0; i < 6; i++) {
                int moveH = tomato.h + MH[i];
                int moveY = tomato.y + MY[i];
                int moveX = tomato.x + MX[i];

                // 갈 수 있는가?
                if((0 <= moveH && moveH < H) && (0 <= moveY && moveY < Y) && (0 <= moveX && moveX < X)) {
                    if(!visited[moveH][moveY][moveX] && map[moveH][moveY][moveX] != -1) {
                        // 체크인
                        visited[moveH][moveY][moveX] = true;
                        mapCount[moveH][moveY][moveX] = mapCount[tomato.h][tomato.y][tomato.x] + 1;
                        // 간다
                        point.add(new Point(moveH, moveY, moveX));
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if(!visited[i][j][k] && mapCount[i][j][k] == 0 && map[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    else result = Math.max(result, mapCount[i][j][k]);
                }
            }
        }
        System.out.print(result);
    }
}
class Point {
    int h;
    int y;
    int x;

    public Point(int h, int y, int x) {
        this.h = h;
        this.y = y;
        this.x = x;
    }
}
