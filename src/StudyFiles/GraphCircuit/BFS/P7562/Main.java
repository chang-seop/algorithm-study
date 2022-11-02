package StudyFiles.GraphCircuit.BFS.P7562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, I;
    static int[][] map;
    static boolean[][] visited;
    static int[][] mapCount;
    static int[] TY = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] TX = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P7562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<Point> point = new LinkedList<>();
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visited = new boolean[I][I];
            mapCount = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX =Integer.parseInt(st.nextToken());

            // 큐 초기화
            point.clear();

            // 시작지점 큐에 넣기
            point.add(new Point(startY, startX));
            map[endY][endX] = 1;

            // BFS
            while(!point.isEmpty()) {
                // 큐에서 가져오기
                Point knight = point.poll();
                // 목적지 인가
                if(map[knight.y][knight.x] == 1) {
                    break;
                }
                // 연결된 곳 순회하기 : 8 방향
                for (int i = 0; i < 8; i++) {
                    int moveY = knight.y + TY[i];
                    int moveX = knight.x + TX[i];

                    if((0 <= moveY && moveY < I) && (0 <= moveX && moveX < I)) {
                        if(!visited[moveY][moveX]) {
                            // 체크인
                            visited[moveY][moveX] = true;
                            mapCount[moveY][moveX] = mapCount[knight.y][knight.x] + 1;
                            // 간다
                            point.add(new Point(moveY, moveX));
                        }
                    }
                }
            }
            sb.append(mapCount[endY][endX]).append("\n");
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