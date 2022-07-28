package DAY03.P9202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] my = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] mx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static int W, N;
    static char[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder resultSb = new StringBuilder();
    static String answer;
    static int sum;
    static int count;
    static TrieNode root = new TrieNode();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P9202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = Integer.parseInt(br.readLine());

        for (int w = 0; w < W; w++) {
            insertTrieNode(br.readLine());
        }

        br.readLine();
        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            sb = new StringBuilder();

            answer = "";
            sum = 0;
            count = 0;

            for (int i = 0; i < 4; i++) {
                String in = br.readLine();
                for (int j = 0; j < 4; j++) {
                    map[i][j] = in.charAt(j);
                }
            }
            br.readLine();
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    //출발 가능 조건 -> root 가 해당 child 를 가지면
                    if(root.hasChild(map[y][x])) {
                        search(y, x, root.getChild(map[y][x]));
                    }
                }
            }
            //결과 출력
            answer = Integer.toString(sum) + " " + answer + " " + Integer.toString(count) + "\n";
            resultSb.append(answer);
            // root 에서부터 isHit 초기화
            root.clearHit();
        }
        System.out.print(resultSb.toString());
    }

    // 참일 경우 a가 사전순으로 앞서는 것 (a 반환), 거짓일 경우 b가 사전순으로 앞서는 것(b 반환) 둘다 같은 단어일 경우 a 반환
    static String stringCompare(String a, String b) {
        for (int i = 0; i < b.length(); i++) {
            if(a.charAt(i) < b.charAt(i)) {
                return a;
            } else if(a.charAt(i) > b.charAt(i)) {
                return b;
            }
        }
        return a;
    }

    static void search(int y, int x, TrieNode node) { // dfs
        // 1. 체크인 -> visited
        visited[y][x] = true;
        sb.append(map[y][x]); // 문자 추가
        // 2. 목적지에 도달하였는가? -> isWord == true, isHit == false
        if(node.isWord && !node.isHit) {
            node.isHit = true;
            //답 작업
            String foundWord = sb.toString();
            int length = foundWord.length();

            // 얻을 수 있는 최대 점수 sum
            sum += score[length];
            // 가장 긴 단어 answer && 같은 문자 길이일 경우 사전 순으로 앞서는 것을 출력
            if(answer.length() == foundWord.length()) {
                answer = stringCompare(answer, foundWord);
            } else if (answer.length() < foundWord.length()) {
                answer = foundWord;
            }
            // 찾은 단어의 개수 count
            count++;

        }
        // 3. 연결된 곳을 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            int ty = y + my[i];
            int tx = x + mx[i];
            // 4. 가능한가? - map 경계, 방문하지 않았는지, node 가 해당 자식을 가지고 있는지
            if(0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
                if(!visited[ty][tx] && node.hasChild(map[ty][tx])) {
                    // 5. 간다
                    search(ty, tx, node.getChild(map[ty][tx]));
                }
            }
        }
        // 6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1); // 뒤에 제거
    }

    static void insertTrieNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a - 'A';
            if(current.child[index] == null) {
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.isWord = true;
    }
}

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isWord = false;
    boolean isHit = false;

    void clearHit() {
        isHit = false;
        for (int i = 0; i < child.length; i++) {
            if(child[i] != null) {
                child[i].clearHit();
            }
        }
    }
    boolean hasChild(char c) {
        return child[c - 'A'] != null;
    }
    TrieNode getChild(char c) {
        return child[c - 'A'];
    }
}