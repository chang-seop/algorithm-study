package StudyFiles.GraphCircuit.BFS.P1926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Y, X;
    static int[][] map;
    static boolean[][] visited;
    static int[] TY = {-1, 1, 0, 0};
    static int[] TX = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P1926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Queue<Point> point = new LinkedList<>();
        map = new int[Y][X];
        visited = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                int value = Integer.parseInt(st.nextToken());
                map[y][x] = value;
                if(value == 0) {
                    visited[y][x] = true;
                }
            }
        }

        int increment = 0;
        int maxCount = 0;
        // BFS
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if(!visited[y][x]) {
                    // 큐에 넣기
                    point.add(new Point(y, x));
                    visited[y][x] = true;
                    int tempCount = 1;
                    while(!point.isEmpty()) {
                        // 큐에서 가져오기
                        Point picture = point.poll();

                        // 연결된 곳 순회하기 : 4방
                        for (int i = 0; i < 4; i++) {
                            int moveY = picture.y + TY[i];
                            int moveX = picture.x + TX[i];

                            // 갈 수 있는가
                            if((0 <= moveY && moveY < Y) &&(0 <= moveX && moveX < X)) {
                                if(!visited[moveY][moveX]) {
                                    // 체크인
                                    visited[moveY][moveX] = true;
                                    tempCount++;
                                    // 간다
                                    point.add(new Point(moveY, moveX));
                                }
                            }
                        }
                    }
                    increment++;
                    maxCount = Math.max(maxCount, tempCount);
                }
            }
        }
        System.out.print(increment + "\n" + maxCount);
    }
}
class Point {
    int y;
    int x;
    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
