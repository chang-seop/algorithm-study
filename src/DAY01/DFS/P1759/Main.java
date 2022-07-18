package DAY01.DFS.P1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int L, C;
    static boolean[] visited;
    static char[] data;
    static int selectedCount = 0;
    static LinkedList result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY01/DFS/P1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        visited = new boolean[C];
        data = new char[C];
        result = new LinkedList<String>();

        for (int i = 0; i < C; i++) data[i] = sc.next().charAt(0);

        Arrays.sort(data);
        dfs(0, 0, 0, -1, "");

        Iterator iter = result.iterator();
        while(iter.hasNext()) System.out.println(iter.next());
    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        //1. 체크인 visited[]
        // 정렬하면 체크인 생략 가능 visited[index] = true;
        //2. 목적지 인가? length == L -> ja 개수, mo 개수 확인 암호 가능 판별
        if(length == L) {
            if(ja >= 2 && mo >= 1) {
                // 정답처리
                result.add(pwd);
            }
        } else {
            //3. 연결된 곳을 순회 : current + 1 ~ C
            for (int i = current + 1; i < C; i++) {
                //4. 갈수 있는가? : 다 갈 수 있음
                //5. 간다 -> ja, mo
                if(data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
                    dfs(length + 1, ja, mo + 1, i, pwd + data[i]);
                }else {
                    dfs(length+1, ja+1, mo, i, pwd + data[i]);
                }
            }
        }
        //6. 체크아웃
        //visited[index] = false;
    }
}
