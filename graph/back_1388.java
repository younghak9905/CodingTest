package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1388 {
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        map = new char[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            String s = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = s.charAt(j-1);
            }
        }


    }

    static void recur(int x, int y)
    {
        Queue<Character> q = new LinkedList<>();
            q.add(map[y][x]);
            visited[y][x] = true;
            while(!q.isEmpty()){
                char c = q.poll();

            }
    }
}
