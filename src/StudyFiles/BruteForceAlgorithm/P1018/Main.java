package StudyFiles.BruteForceAlgorithm.P1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Y, X;
    static boolean[][] map;
    static int min = Integer.MAX_VALUE; // 최소 값
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/BruteForceAlgorithm/P1018/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            String temp = br.readLine();
            for (int x = 0; x < X; x++) {
                if(temp.charAt(x) == 'W') {
                    map[y][x] = true;
                } else {
                    map[y][x] = false;
                }
            }
        }
        for (int y = 0; y < Y - 7; y++) { // 최대 Y - 7
            for (int x = 0; x < X - 7; x++) { // 최대 X - 7
                int yEnd = y + 7;
                int xEnd = x + 7;

                int count = 0;
                boolean isWhiteBlack = map[y][x]; // 현재 y, x의 체스판 색상 저장
                boolean isBlackWhite = !isWhiteBlack; // 반대의 경우를 생각

                for (int currentY = y; currentY <= yEnd; currentY++) { // 현재 y 값
                    for (int currentX = x; currentX <= xEnd; currentX++) { // 현재 x 값
                        if(map[currentY][currentX] != isWhiteBlack) {
                            count++;
                        }

                        // 다음 수 비교, 반대로 바꿔야됨
                        isWhiteBlack = !isWhiteBlack;
                    }
                    // 다음 줄 비교, 반대로 바꿔야됨
                    isWhiteBlack = !isWhiteBlack;
                }

                min = Math.min(min, count);

                count = 0;

                for (int currentY = y; currentY <= yEnd; currentY++) { // 현재 y 값
                    for (int currentX = x; currentX <= xEnd; currentX++) { // 현재 x 값
                        if(map[currentY][currentX] != isBlackWhite) {
                            count++;
                        }

                        // 다음 수 비교, 반대로 바꿔야됨
                        isBlackWhite = !isBlackWhite;
                    }
                    // 다음 줄 비교, 반대로 바꿔야됨
                    isBlackWhite = !isBlackWhite;
                }

                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }
}
