package StudyFiles.GraphCircuit.BFS.P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] mapCount;
    final static int[] MY = {0, 0, -1, 1};
    final static int[] MX = {-1, 1, 0, 0};
    static int Y, X;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();
        map = new int[Y][X];
        mapCount = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                int point = Integer.parseInt(st.nextToken());
                if(point == 1) {
                    // 큐에 넣기
                    queue.add(new Point(y, x));
                }
                map[y][x] = point;
            }
        }

        //BFS
        while(!queue.isEmpty()) {
            //큐에서 꺼내오기
            Point point = queue.poll();
            //목적지인가
            //연결된 곳 순회하기
            for(int i = 0; i < 4; i++) {
                int ty = point.y + MY[i];
                int tx = point.x + MX[i];

                // 맵 안에 들어오는가
                if(0 <= ty && ty < Y && 0 <= tx && tx < X) {
                    // map 에 있는 값이 0 일 경우
                    if(map[ty][tx] == 0) {
                        //체크인
                        map[ty][tx] = 1;
                        mapCount[ty][tx] = mapCount[point.y][point.x] + 1;
                        max = Math.max(mapCount[ty][tx], max);
                        //큐에 넣기기
                       queue.add(new Point(ty, tx));
                    }
                }
            }
        }

        // 맵 안에 탐색을 못한 경우를 체크
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if(map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        if(max == Integer.MIN_VALUE) System.out.print(0);
        else System.out.print(max);
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

}