package StudyFiles.GraphCircuit.P2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static final int[] MY = {0, -1, 0, 1}; // < ^ > v
    static final int[] MX = {-1, 0, 1, 0 }; // < ^ > v
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/P2178/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; // 맵
        dp = new int[N][M]; // 이동 거리
        Queue<Point> queue = new LinkedList<Point>();
        //입력 부분
        for (int y = 0; y < N; y++) {
            String temp = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = temp.charAt(x) - '0';
            }
        }

        Point point = new Point(0, 0);

        // BFS
        queue.offer(point);
        while(!queue.isEmpty()) {
            //큐에서 꺼내기
            Point player = queue.poll();
            //목적지 인가?
            if(player.y == N - 1 && player.x == M - 1) {
                System.out.println(dp[player.y][player.x] + 1);
                break;
            }
            //연결된 곳 순회하기
            for (int i = 0; i < 4; i++) {
                int ty = player.y + MY[i];
                int tx = player.x + MX[i];
                //갈 수 있는가?
                if(0 <= ty && ty < N && 0 <= tx && tx < M && dp[ty][tx] == 0) {
                    //체크인
                    //갈 수 있는가?
                    if(map[ty][tx] == 1) {
                        dp[ty][tx] = dp[player.y][player.x] + 1;
                        //큐에 넣는다
                        queue.add(new Point(ty, tx));
                    }
                }
            }
        }
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
