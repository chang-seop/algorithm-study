package DAY03.P1202;

import java.io.*;
import java.util.*;

// 우선 순위 큐를 이용
public class Main {
    static int K, N;
    static PriorityQueue<Jewel> pq;
    static int[] backpacks;
    static Jewel[] jewels;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //보석 입력
        jewels = new Jewel[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[n] = new Jewel(weight, price);
        }

        //가방 입력
        backpacks = new int[K];
        for (int k = 0; k < K; k++) {
            backpacks[k] = Integer.parseInt(br.readLine());
        }

        // 가방 오름차순 정렬
        Arrays.sort(backpacks);
        // 보석 오름차순 정렬 (무게순으로)
        Arrays.sort(jewels, Comparator.comparingInt(Jewel::getWeight));
        // 보석 가격이 높은값 기준 힙
        PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparingInt(Jewel::getPrice).reversed());

        // pointer -> jIndex, pointer -> i 이용
        int jIndex = 0;
        long result = 0;
        // 1. 남은 가방 중 제일 작은 가방을 선택. <- 정렬
        for (int i = 0; i < backpacks.length; i++) {
            // 2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택. <- 힙을 사용.
            while(jIndex < N && jewels[jIndex].weight <= backpacks[i]) {
                pq.add(jewels[jIndex++]);
            }
            if(!pq.isEmpty()) { // 가방에 넣을 수 있는 보석이 없을 수 있으므로
                result += pq.poll().price;
            }
        }
        System.out.println(result);
    }
}
class Jewel {
    int weight;
    int price;
    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
    public int getPrice() { return price; }
    public int getWeight() { return weight; }
    @Override
    public String toString() {
        return "Jewel{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}
