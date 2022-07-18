package DAY01.DFS.P1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int selectedCount = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY01/DFS/P1062/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        words = new String[N];
        visited = new boolean[26];

        if(K < 5) { // a n t i c 꼭 필요함 5개 이하면 0 출력
            System.out.println(0);
            return;
        }else if (K == 26) { // 모든 알파벳 가능하면 다 가능!
            System.out.println(N);
            return;
        } else {
            //"antic" 라는 키워드를 공백으로 처리
            for (int i = 0; i < N; i++) words[i] = sc.next().replaceAll("[antic]", "");
        }
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        selectedCount = -1;

        dfs(0);
        System.out.println(max);
    }
    static void dfs(int index) {
        // 1. 체크인
        visited[index] = true;
        selectedCount++;
        // 2. 목적지 인가?  : selectedCount == K => 읽을 수 있는 단어 개수 계산
        if(selectedCount == K - 5) {
            //계산
            max = Math.max(max, countWords());
        } else {
            for (int i = index + 1; i <= 25; i++) { // 3. 연결된곳 순회하기: index + 1 ~ 25
                // 4. 갈 수 있는가? : 방문 여부, ab ba 차이
                if(!visited[i]) {
                    // 5. 간다 : dfs
                    dfs(i);
                }
            }
        }
        // 6. 체크 아웃
        visited[index] = false;
        selectedCount--;
    }

    static int countWords() {
        int count = 0;
        // 단어 만큼 반복
        for (int n = 0; n < N; n++) {
            boolean isPossible = true;
            for (int i = 0; i < words[n].length(); i++) {
                if(!visited[words[n].charAt(i) - 'a']) { //방문 한 적이 있는지 판별
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) count++;
        }
        return count;
    }
}

// 제외 할 수 있는 케이스는 구현 후 생각하기
