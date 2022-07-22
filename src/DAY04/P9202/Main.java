package DAY04.P9202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static TrieNode root = new TrieNode();
    static int W, N;
    static String answer;
    static int sum, count;
    static int[] PY = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] PX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static char[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY04/P9202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();

        W = Integer.parseInt(br.readLine());

        for (int w = 0; w < W; w++) {
            String words = br.readLine();
            trie.add(words);
        }

        br.readLine();
        N = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

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
            //최대 점수

            //가장 긴 단어
            //찾은 단어의 개수
            root.clearHit();
        }
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

    static void search(int y, int x, TrieNode node) {
        // 1. 체크인
        visited[y][x] = true;
        sb.append(map[y][x]); // 추가
        // 2. 목적지에 도달하였는가? -> isWord == true, isHit == false
        if(node.isWord && !node.isHit) {
            node.isHit = true;
            // 답 작업 -> 길이, 단어, 개수
            String foundWord = sb.toString();
            int length = foundWord.length();
        }
        // 3. 연결된 곳을 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            int ty = y + PY[i];
            int tx = x + PX[i];
            // 4. 가능한가? - map 경계, 방문하지 않았는지, node 가 해당 자식을 가지고 있는지
            if(0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
                if(!visited[ty][tx] && node.hasChild(map[ty][tx])) {
                    // 5. 간다
                    search(ty, tx, node.getChild(map[ty][tx]));
                }
            }
        }
        // 6. 체크아웃
        sb.deleteCharAt(sb.length() - 1); // 뒤에 거 제거
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