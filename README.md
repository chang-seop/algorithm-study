# algorithm-study

각 디렉토리 이름에 문제 번호가 있으며, 사이트에 검색 하시면 문제를 보실 수 있습니다. [백준 사이트](https://www.acmicpc.net)

정렬
1. O(n^2)
    * Selection Sort (선택 정렬)
    * Bubble Sort (버블 정렬)

2. O(n log n)
    * Heap Sort (힙 정렬)
    * Merge Sort (합병 정렬)
 
3. O(kn)
    * Radix Sort (기수 정렬)
 
4. O(k + n)
    * Counting Sort (카운팅 정렬)

정수론
* 유클리드 호제법
* 확장 유클리드 호제법 
* 에라토스테네스의 체

조합론
* 순열, 조합, 원순열, 중복조합
* 파스칼의 삼각형

그래프 
* disjoint Set (서로소 집합) (Union-Find)
* DAG (유향 비순환 그래프) (Directed Acyclic Graph)
* 위상정렬(Topological Sort)
* DFS 깊이 우선 탐색 (깊이 우선 신장 트리)
* BFS 너비 우선 탐색 (너비 우선 신장 트리)
* 최소 신장 트리 (MST : Minimum Spanning Tree)
    1. 크루스칼 알고리즘
    2. 프림 알고리즘
* 최소 공통 조상(Lowest Common Ancestor / LCA)
* 단절점 (Articulation Points / Cut Vertices)
* 최단경로
    1. 다익스트라 알고리즘(Dijkstra Algorithm) O(ElogV) 시작정점 1개 -> 모든 정점 최소비용 (단, 음수가중치 없음)
    2. 벨만-포드 알고리즘(Bellman-Ford-Moore Algorithm) O(VE) 시작정점 1개 -> 모든 정점 최소비용 (음수가중치 존재, 음수사이클이 존재하면 최소비용 없음)
    3. 플로이드-워셜 알고리즘(Floyd-Warshall Algorithm)  O(V^3) 모든 정점에서 모든 다른 정점 최소비용 (음수가중치 존재, 음수사이클 없어야 함)

동적 계획법(Dynamic Programming)
* 최장 증가 부분 수열 알고리즘(Longest Increasing Subsequence / LIS)

자료구조
* 스택
* 큐
* 셋(set)
* 맵(map)
* Trie