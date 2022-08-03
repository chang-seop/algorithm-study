package SamsungAlgorithmStudy.DAY03.P9202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTrie {
    static int W;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SamsungAlgorithmStudy/DAY03/P9202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();

        W = Integer.parseInt(br.readLine());

        for (int w = 0; w < W; w++) {
            String words = br.readLine();
            trie.add(words);
        }

        int b = Integer.parseInt(br.readLine());
        //보드 판
        for (int i = 0; i < b; i++) {
        }

    }
}
class Trie {
    Node root;
    boolean[][] visited = new boolean[4][4];

    // 8방향           왼 왼위 위 우위 오 오밑 밑,왼밑
    static int[] PY = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] PX = {-1, -1, 0, 1, 1, 1, 0, -1};
    public Trie() {
        this.root = new Node();
        this.root.val = ' ';
    }
    public static class Node {
        Node[] child = new Node[26];
        boolean isWord = false;
        boolean isHit = false;
        int childNum = 0;
        char val;
        // isHit 초기화 함수 구현
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
        Node getChild(char c) {
            return child[c - 'A'];
        }
    }
    void add(String words) {
        Node currentNode = this.root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            int index = c - 'A'; //문제가 대문자 이기 때문에 'A'를 뺀다

            if(currentNode.child[index] == null) {
                currentNode.child[index] = new Node();
                currentNode.child[index].val = c;
                currentNode.childNum++;
            }
            currentNode = currentNode.child[index];
        }
        currentNode.isWord = true;
    }

    //DFS
    int check(int y, int x) {
        // 1. 체크인

        // 2. 목적지에 도달하였는가? -> isWord == true, isHit == false
        // 3. 연결된 곳을 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            y += PY[i];
            x += PX[i];
            // 4. 가능한가? - map 경계, 방문하지 않았는지, node 가 해당 자식을 가지고 있는지
        }
        // 5. 체크아웃
        return 1;
    }
}