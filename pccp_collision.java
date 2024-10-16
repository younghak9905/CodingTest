import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class pccp_collision {
    static int[][][]visited;
    public int solution(int[][] points, int[][] routes) {


       visited = new int[202][100][100];
        int result=0;
        Queue<now>queue = new LinkedList<>();
        for(int i=0;i<routes.length;i++)
        {
            int y1 = points[routes[i][0]-1][0];
            int x1 = points[routes[i][0]-1][1];
            int y2 = points[routes[i][1]-1][0];
            int x2 =points[routes[i][1]-1][1];
            queue.add(new now(x1,y1,x2,y2));
        }

        while(!queue.isEmpty())
        {
            now now = queue.poll();
            int x1 = now.x;
            int y1 = now.y;
            int x2 = now.targetx;
            int y2 = now.targety;
            int distanceX = Math.abs(x1-x2);
            int distanceY = Math.abs(y1-y2);
            int time =0;

            for(int i=0;i<=distanceY;i++)
            {
                if(y1<=y2)
                {
                      if(visited[i][y1+i][x1]==1)
                      {
                          result++;
                          visited[i][y1+i][x1]=2;
                      }else if(visited[i][y1+i][x1]==0)
                            visited[i][y1+i][x1] =1;
                }
                else {
                    if(visited[i][y1-i][x1]==1)
                    {
                        result++;
                        visited[i][y1-i][x1]=2;
                    }else if(visited[i][y1-i][x1]==0)
                        visited[i][y1-i][x1] = 1;
                }
                time=i;
            }
            for(int i=1;i<=distanceX;i++)
            {
                if(x1<=x2)
                {
                    if(visited[time+i][y2][x1+i]==1)
                    {
                        result++;
                        visited[time+i][y2][x1+i]=2;
                    }else if(visited[time+i][y2][x1+i]==0){
                        visited[time+i][y2][x1+i] = 1;
                    }


                }
                else {
                    if(visited[i][y2][x1-i]==1)
                    {
                        result++;
                        visited[i][y2][x1-i]=2;
                    }else if(visited[i][y2][x1-i]==0){
                        visited[i][y2][x1-i] = 1;
                    }

                }
            }
        }

        return result;
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
      //[3, 2], [6, 4], [4, 7], [1, 4]]
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        	//[[4, 2], [1, 3], [4, 2], [4, 3]]
        int[][] routes = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        int ret = sol.solution(points, routes);
        System.out.println(ret);
    }
}
