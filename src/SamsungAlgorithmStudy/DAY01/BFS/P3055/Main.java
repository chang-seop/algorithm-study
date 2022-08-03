package SamsungAlgorithmStudy.DAY01.BFS.P3055;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //                      좌, 우, 위, 아래 (조이스틱)
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};
    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;
    static boolean foundAnswer = false;
    static int result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY01/BFS/P3055/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        Point st = null;

        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c] == '*') {
                    queue.add(new Point(r, c, '*'));
                } else if(map[r][c] == 'S') {
                    st = new Point(r, c, 'S');
                }
            }
        }
        queue.add(st);
        // Q [ *, S ] 물에 인접해있는 .에는 고슴도치가 이동할 수 없다!

        while (!queue.isEmpty()) {
            //1. 큐에서 꺼내옴 -> '*', 'S', '.', 'D'(4가지 케이스)
            Point p = queue.poll();
            //2. 목적지인가? -> D -> 목적지 도착
            if(p.type == 'D') {
                // 답 출력
                result = dp[p.y][p.x];
                foundAnswer = true;
                break;
            }
            //3. 연결된 곳을 순회 -> 상하좌우!
            for (int i = 0; i < 4; i++) {
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];
                //4. 갈 수 있는가? (공통) : 맵안에 들어오는가
                if(0 <= ty && ty < R && 0 <= tx && tx < C) {
                    // 고슴도치
                    if(p.type == 'S' || p.type == '.') {
                        //4. 갈 수 있는가? (고슴도치) : '.' or 'D', &&  방문하지 않은 곳
                        if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
                            //5. 체크인 (고슴도치) : dp[][] = 이동거리
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            //6. 큐에 넣음
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }
                        // 물
                    } else if(p.type == '*') {
                        //4. 갈 수 있는가? (물) : '.', 'S'
                        if(map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            //5. 체크인 (물) : map[][] = *
                            map[ty][tx] = '*';
                            //6. 큐에 넣음
                            queue.add(new Point(ty, tx, '*'));
                        }
                    }
                }
            }
        }
        if(!foundAnswer) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }
}

// 고슴도치 : 연결 : 상하좌우
//갈수 있는가? : 지도, 'D', '.'
//물 : 연결 : 상하좌우
//갈수 있는가? : 지도