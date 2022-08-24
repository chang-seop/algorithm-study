package StudyFiles.DataStructures.P9012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P9012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        while(N-- > 0) {
            char[] nString = br.readLine().toCharArray();
            boolean visited = false;
            stack.clear();
            stack.push('C');
            for (int i = 0; i < nString.length; i++) {
                if(nString[i] == ')'){
                    if(stack.peek() == 'C') {
                        stack.pop();
                        visited = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else {
                    stack.push('(');
                }
            }
            if(visited || stack.peek() != 'C') System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
