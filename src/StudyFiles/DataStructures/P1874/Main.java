package StudyFiles.DataStructures.P1874;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P1874/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) queue.add(Integer.parseInt(br.readLine()));

        boolean visited = false;
        int i = 1, count = 1;
        while (!queue.isEmpty()) {
            if(count > 2 * N) {
                visited = true;
                break;
            }

            if(stack.isEmpty()) {
                sb.append("+").append("\n");
                stack.push(i++);
            }
            else if(!Objects.equals(stack.peek(), queue.peek())) {
                sb.append("+").append("\n");
                stack.push(i++);
            }
            else {
                sb.append("-").append("\n");
                queue.poll();
                stack.pop();
            }
            count++;
        }
        if(visited) System.out.print("NO");
        else System.out.print(sb);
    }
}
