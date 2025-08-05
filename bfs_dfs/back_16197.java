package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_16197 {
    static char[][] map;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][][] visited;
    static int[] one  = new int[2];
    static int[] two = new int[2];
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        visited = new boolean[N+1][M+1][N+1][M+1];

        for(int i=1;i<=N;i++){
            String s = br.readLine();
            for(int j=1;j<=M;j++){

                map[i][j] = s.charAt(j-1);
                if(map[i][j]=='o'){
                    if(one[0]==0){
                        one[1]=i;
                        one[0]=j;
                    }else{
                        two[1]=i;
                        two[0]=j;
                    }
                }
            }
        }

        System.out.print(recur(one,two));
    }
    static int recur(int[] one,int[] two){

        Queue<towCoins> q = new LinkedList<>();
       q.offer(new towCoins(one[0],one[1],two[0],two[1],0));
        visited[one[1]][one[0]][two[1]][two[0]]=true;
        while(!q.isEmpty()){
            towCoins coins = q.poll();
            if(coins.count>=10) break;


            for(int i=0;i<4;i++){

                int x1 = coins.x1+dx[i];
                int y1 = coins.y1+dy[i];
                int x2 = coins.x2+dx[i];
                int y2 = coins.y2+dy[i];

                if(x1>=1 && y1>=1 && x1<=M &&y1<=N && map[y1][x1]=='#')
                {
                    x1=coins.x1;
                    y1=coins.y1;
                }
                if(x2>=1 && y2>=1 && x2<=M &&y2<=N && map[y2][x2]=='#'){
                    x2=coins.x2;
                    y2=coins.y2;
                }

                int flag=0;
                if(x1>=1 && y1>=1 && x1<=M &&y1<=N) flag++;
                if(x2>=1 && y2>=1 && x2<=M &&y2<=N) flag++;
                if(flag==1) return coins.count+1;
                else if(flag==2 && !visited[y1][x1][y2][x2]) {
                    visited[y1][x1][y2][x2]=true;
                    q.add(new towCoins(x1,y1,x2,y2,coins.count+1));
                }

            }
        }
        return -1;

    }

    public static class towCoins { //두 동전의 위치와 현재 버튼을 누른 횟수를 기록하는 객체
        int x1;
        int y1;
        int x2;
        int y2;
        int count;

        public towCoins(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }
}
