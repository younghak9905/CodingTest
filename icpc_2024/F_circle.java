package icpc_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class F_circle {
    static int POINTS_ON_CIRCLE = 3600;  // 원 둘레를 구성하는 총 점의 수
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: 선분의 개수 입력 받기
        int n = scanner.nextInt();

        // 원을 나누는 그래프 초기화
        graph = new ArrayList[POINTS_ON_CIRCLE];
        for (int i = 0; i < POINTS_ON_CIRCLE; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: 각 선분을 읽어서 무방향 그래프 생성
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph[start].add(end);
            graph[end].add(start);
        }

        // Step 3: 자원 위치 입력 받기
        int resource1Direction = scanner.nextInt();
        int resource1Distance = scanner.nextInt();  // 거리 정보는 문제에서 필요하지 않음
        int resource2Direction = scanner.nextInt();
        int resource2Distance = scanner.nextInt();

        // Step 4: DFS 또는 BFS를 통해 두 자원 위치 간 연결 여부 확인
        visited = new boolean[POINTS_ON_CIRCLE];
        boolean canObtainBothResources = dfs(resource1Direction, resource2Direction);

        // Step 5: 결과 출력
        System.out.println(canObtainBothResources ? "YES" : "NO");
        scanner.close();
    }

    static boolean dfs(int current, int target) {
        if (current == target) return true;
        visited[current] = true;

        for (int neighbor : graph[current]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, target)) return true;
            }
        }

        return false;
    }
}
