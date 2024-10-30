package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_3190 {
    static int dy [] = {0,1,0,-1};
    static int dx [] = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int [][]map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<=K;i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y]=1;
        }
        int L = Integer.parseInt(br.readLine());
        HashMap<Integer,String> change = new HashMap<>();
        for (int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            change.put(X,C);
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1,1});

        int dir=1;
        int time=0;
        while(true)
        {

            time++;

            int []now = snake.peekFirst();
            int x = now[0] + dx[dir];
            int y = now[1]+ dy[dir];

            if(x<1 || x>N || y<1 || y>N || map[x][y]==2) break;
            if(map[x][y]==1) {
                snake.addFirst(new int[]{x,y});
            }
            else
            {
                snake.addFirst(new int[]{x,y});
                int []tail = snake.pollLast();
                map[tail[0]][tail[1]]=0;
            }
            map[x][y]=2;

            if(change.get(time)!=null)
            {
                String c = change.get(time);
                if(c.equals("D"))
                {
                    dir = (dir+3)%4;
                }
                else
                {
                    dir = (dir+1)%4;
                }
            }
        }
        System.out.println(time);


    }
}

//6  보드 크기  N
//3  사과 개수 K
//3 4  사과 위치
//2 5
//5 3
//3 방형 변환 횟수 L
//3 D  3초 뒤 오른쪽
//15 L 15초 뒤 왼쪽
//17 D 17초 뒤 오른쪽
