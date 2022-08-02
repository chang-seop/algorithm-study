package StudyFiles.P11650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/P11650/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions.add(new Position(x, y));
        }

        Comparator<Position> cp = new Comparator<>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.x > o2.x) return 1; // 1 : swap
                else if(o1.x == o2.x) {
                    if(o1.y > o2.y) return 1;
                    else if(o1.y == o2.y) return 0; // 0 : equals
                    else return -1;
                } else return -1; // : don't move
            }
        };

        positions.sort(cp);

        for (int i = 0; i < N; i++) {
            sb.append(positions.get(i).getX()).append(" ").append(positions.get(i).getY()).append("\n");
        }

        System.out.println(sb);

    }
}
class Position {
    int x;
    int y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
