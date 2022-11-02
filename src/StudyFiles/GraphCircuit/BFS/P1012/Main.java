package StudyFiles.GraphCircuit.BFS.P1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, Y, X, K;
    static int[][] map;
    static int[][] mapCount;
    static boolean[][] visited;
    static int[] TY = {-1, 1, 0, 0};
    static int[] TX = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P1012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        Queue<Point> point = new LinkedList<>();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            point.clear();
            map = new int[Y][X];
            mapCount = new int[Y][X];
            visited = new boolean[Y][X];

            int increment = 0;

            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                visited[y][x] = true;
            }

            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if(visited[y][x]) {
                        //큐에 넣기
                        visited[y][x] = false;
                        point.add( new Point(y, x));
                        // BFS
                        while(!point.isEmpty()) {
                            // 큐에서 꺼내오기
                            Point beChu = point.poll();

                            // 연결된 곳 순회하기 : 4 방향
                            for (int i = 0; i < 4; i++) {
                                int moveY = beChu.y + TY[i];
                                int moveX = beChu.x + TX[i];

                                // 갈 수 있는가
                                if((0 <= moveY && moveY < Y) &&(0 <= moveX && moveX < X)) {
                                    if(visited[moveY][moveX]) {
                                        // 체크인
                                        visited[moveY][moveX] = false;
                                        // 간다
                                        point.add(new Point(moveY, moveX));
                                    }
                                }
                            }
                        }
                        increment++;
                    }
                }
            }
            sb.append(increment).append("\n");
        }

        System.out.print(sb);
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