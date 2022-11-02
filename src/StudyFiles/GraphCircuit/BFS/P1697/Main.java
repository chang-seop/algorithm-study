package StudyFiles.GraphCircuit.BFS.P1697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int mapSize = 100001;
    static char[] map;
    static int[] mapCount;
    static int N, K;
    static int[] TX = {1, -1, 2};
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/GraphCircuit/BFS/P1697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new char[mapSize];
        visited = new boolean[mapSize];
        mapCount = new int[mapSize];
        Queue<Integer> point = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map[N] = 'S';
        map[K] = 'E';
        // 큐에 넣기
        point.add(N);
        // BFS
        while(!point.isEmpty()) {
            // 큐에서 꺼내오기
            int suBin = point.poll();
            // 목적지 인가?
            if(map[suBin] == 'E') {
                System.out.print(mapCount[suBin]);
                break;
            }
            // 연결된 곳 순회하기 : 2 방향, 1 텔레포트
            for (int i = 0; i < 3; i++) {
                int moveX = suBin + TX[i];
                if(TX[i] == 2) {
                    moveX = suBin * 2;
                }

                if(0 <= moveX && moveX < 100001) {
                    if(!visited[moveX]) {
                        // 체크인
                        visited[moveX] = true;
                        mapCount[moveX] = mapCount[suBin] + 1;
                        // 간다
                        point.add(moveX);
                    }
                }
            }
        }
    }
}
