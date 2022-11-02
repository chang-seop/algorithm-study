package StudyFiles.GraphCircuit.BFS.P10026;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main  {
    static int N;
    static char[][] map;
    static boolean[][] defaultVisited;
    static boolean[][] redVisited;
    static int[] TY = {-1, 1, 0, 0};
    static int[] TX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P10026/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        defaultVisited = new boolean[N][N];
        redVisited = new boolean[N][N];
        Queue<Point> point1 = new LinkedList<>();
        Queue<Point> point2 = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            String input = br.readLine();
            for (int x = 0; x < N; x++) map[y][x] = input.charAt(x);
        }

        int increment1 = 0;
        int increment2 = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {

                if(!defaultVisited[y][x]) {
                    defaultVisited[y][x] = true;
                    // 큐에 넣기
                    point1.add(new Point(y, x, map[y][x]));
                    while(!point1.isEmpty()) {
                        // 큐에서 가져오기
                        Point infoRGB = point1.poll();
                        // 연결된 곳 순회 : 4방
                        for (int i = 0; i < 4; i++) {
                            int moveY = infoRGB.y + TY[i];
                            int moveX = infoRGB.x + TX[i];

                            // 갈 수 있는가?
                            if((0 <= moveY && moveY < N) && (0 <= moveX && moveX < N)) {
                                if(!defaultVisited[moveY][moveX] && infoRGB.RGB == map[moveY][moveX]) {
                                    // 체크인
                                    defaultVisited[moveY][moveX] = true;
                                    // 간다
                                    point1.add(new Point(moveY, moveX, infoRGB.RGB));
                                }
                            }
                        }
                    }
                    increment1++;
                }

                // 적록색약
                if(!redVisited[y][x]) {
                    redVisited[y][x] = true;
                    // 큐에 넣기
                    point2.add(new Point(y, x, map[y][x]));
                    while(!point2.isEmpty()) {
                        Point infoRGB = point2.poll();
                        // 연결된 곳 순회하기 : 4방
                        for (int i = 0; i < 4; i++) {
                            int moveY = infoRGB.y + TY[i];
                            int moveX = infoRGB.x + TX[i];

                            // 갈 수 있는가
                            if((0 <= moveY && moveY < N) && (0 <= moveX && moveX < N)) {
                                if(!redVisited[moveY][moveX] && infoRGB.RGB == map[moveY][moveX]) {
                                    // 체크인
                                    redVisited[moveY][moveX] = true;
                                    // 간다
                                    point2.add(new Point(moveY, moveX, infoRGB.RGB));
                                }
                                else if(!redVisited[moveY][moveX] && (infoRGB.RGB == 'R' || infoRGB.RGB == 'G')) {
                                    if(map[moveY][moveX] == 'R' || map[moveY][moveX] == 'G') {
                                        // 체크인
                                        redVisited[moveY][moveX] = true;
                                        // 간다
                                        point2.add(new Point(moveY, moveX, infoRGB.RGB));
                                    }
                                }
                            }
                        }
                    }
                    increment2++;
                }

            }
        }
        System.out.print(increment1 + " " + increment2);
    }
}
class Point {
    int y;
    int x;
    char RGB;
    public Point(int y, int x, char RGB) {
        this.y = y;
        this.x = x;
        this.RGB = RGB;
    }
}
