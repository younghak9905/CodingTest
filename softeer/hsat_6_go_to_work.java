package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class hsat_6_go_to_work {
    static int n, m;
    static int s, t;
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;

    static HashMap<Integer, Integer> map1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        dfs(s, t, graph, s1, new boolean[n + 1]);
        dfs(t, -1, reverseGraph, s2, new boolean[n + 1]);
        s1.retainAll(s2); //교집합

        System.out.println(s1);
        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();
        dfs(t, s, graph, s3, new boolean[n + 1]);
        dfs(s, -1, reverseGraph, s4, new boolean[n + 1]);
        s3.retainAll(s4); //교집합
        System.out.println(s3);
        s1.retainAll(s3);

        int answer = s1.size();
        if (s1.contains(s)) answer--;
        if (s1.contains(t)) answer--;
        System.out.println(answer);
    }

    static void dfs(int start,int end,List<List<Integer>> g,Set<Integer> s,boolean[] check) {
        if (end != -1 && start == end) return;

        for (int i = 0; i < g.get(start).size(); i++) {
            int a = g.get(start).size();
            int next = g.get(start).get(i);
            if (check[next]) continue;
            check[next] = true;
            s.add(next);
            dfs(next, end, g, s, check);
        }
        return;
    }
}
    //5 9  n 정점 수 ,m 간선 수
//1 2
//1 4
//2 1
//2 3
//3 4
//3 5
//4 1
//4 3
//5 1
//1 3
