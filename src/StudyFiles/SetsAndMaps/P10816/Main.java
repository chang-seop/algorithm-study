package StudyFiles.SetsAndMaps.P10816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nArray, mArray, keys;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SetsAndMaps/P10816/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mArray = new int[M];
        keys = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            keys[i] = mArray[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(); //해시 맵 성질을 이용하여 key 에 덮어쓰기 가능

        //정렬
        Arrays.sort(mArray);

        //이분 탐색 n log m
        for (int target : nArray) {
            int high = mArray.length - 1;
            int low = 0, mid = 0;
            while(low <= high) {
                mid = (high + low) / 2;
                if(mArray[mid] == target) {
                    //현재 해시맵에 target 인 key 가 없다면 1을 put
                    if(!hashMap.containsKey(target)) {
                        hashMap.put(target, 1);
                    } else { // 현재 해시맵에 target 인 key 가 있다면 원래 있던 값 + 1을 put
                        hashMap.put(target, hashMap.get(target) + 1);
                    }
                    break;
                }
                if(mArray[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        for (int key : keys) {
            if(hashMap.get(key) == null) sb.append(0).append(" ");
            else sb.append(hashMap.get(key)).append(" ");
        }
        System.out.print(sb);
    }
}
