package pccp;

import java.util.ArrayList;



public class pccp_collision {
    static int[][][]visited;
    static int result=0;
    static ArrayList<Integer>[]edges;
    static StringBuilder sb;
    public int solution(int[][] points, int[][] routes) {
        sb = new StringBuilder();
        edges = new ArrayList[101*100];
        visited = new int[101*100][101][101];

        for(int i=0;i<routes.length;i++)
        {   edges[i] = new ArrayList<>();
            for(int j=0;j<routes[i].length;j++)
            {
               edges[i].add(routes[i][j]);
            }

        }



        for(int k=0;k<routes.length;k++)
        {
           int x = points[edges[k].get(0)-1][1];
           int y = points[edges[k].get(0)-1][0];
           edges[k].remove(0);

            int time =0;
            int cnt=0;
            for(int j:edges[k]) {

                int targetx = points[j-1][1];
                int targety = points[j-1][0];
                now now = new now(x,y,targetx,targety);
                int x1 = now.x;
                int y1 = now.y;
                int x2 = now.targetx;
                int y2 = now.targety;
                int distanceX = Math.abs(x1-x2);
                int distanceY = Math.abs(y1-y2);
                time+=cnt;
                isNow(time+cnt,now.x,now.y);
                cnt=1;

                for(int i=1;i<=distanceY;i++)
                {
                    time++;
                    if(y1==y2)
                        isNow(time,now.x,now.y);
                    else if(y1<y2)
                    {     now.y++;
                        isNow(time,now.x,now.y);
                    }
                    else {
                        now.y--;
                        isNow(time,now.x,now.y);
                    }

                }
                for(int i=1;i<=distanceX;i++)
                {   time++;
                    if(x1==x2)
                        isNow(time,now.x,now.y);
                    else if(x1<x2)
                    {
                        now.x++;
                        isNow(time,now.x,now.y);
                    }
                    else {
                        now.x--;
                        isNow(time,now.x,now.y);
                    }

                }
                x=now.targetx;
                y=now.targety;
            }


        }

       //System.out.println(sb);
        return result;
    }
    static void isNow(int time,int x,int y)
    {
        if(visited[time][y][x]==1)
        {
            visited[time][y][x]=2;
            //sb.append(time+" "+x+" "+y+" ").append("\n");
            result++;
        }
        else if(visited[time][y][x]==0)
        {
            visited[time][y][x]=1;
        }
    }

    static class now{
        int x;
        int y;
        int targetx;
        int targety;
        public now(int x, int y,int targetx,int targety)
        {
            this.x = x;
            this.y = y;
            this.targetx = targetx;
            this.targety = targety;
        }
    }


    public static void main(String[] args) {
        pccp_collision sol = new pccp_collision();
      //[[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]]
        int[][] points = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
     //   [[2, 3, 4, 5], [1, 3, 4, 5]]
        int[][] routes = {{2, 3, 4, 5}, {1, 3, 4, 5}};
        int ret = sol.solution(points, routes);
        System.out.println(ret);
    }
}
