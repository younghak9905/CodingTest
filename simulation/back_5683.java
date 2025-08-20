package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_5683 {
    static int[][]dx ={{1,0,-1,0},{-1,0,1,1},{0,-1,0,1},{0,1,0,-1}};;

    static int[][]dy ={{0,1,0,-1},{0,-1,0,1},{1,0,-1,0},{-1,0,1,0}};
    static int[][]map;
    static int max=0;
    static int N,M;
    static ArrayList<int[]> cctv = new ArrayList<>();
    static Stack<Integer> result = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        int cnt=0;
        int wall=0;
        for(int i=1;i<=N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>=1 && map[i][j]<=5)
                {
                    cnt++;
                    cctv.add(new int[]{i,j,map[i][j]});
                }
                if(map[i][j]==6)
                {
                    wall++;
                }
            }
        }
        recur(cnt,new Stack<>());
        System.out.println(N*M-max-wall);

    }
    static void recur(int cnt,Stack<Integer> stack){
        if(cnt==0)
        {
            int sum=cctv.size();
            int index=0;
            int[][]temp = map;
           for(Integer num : stack){

               int []cam = cctv.get(index);
               for(int i=0;i<4;i++)
               {   int go=1;
                   if(cam[2]==1 && i>=1) continue;
                   if(cam[2]==2 && i>=2) continue;
                   if(cam[2]==3 && (i==1 || i==3)) continue;
                   if(cam[2]==4 && i==3) continue;


                   while(true)
                   {
                       int nx = cam[1] + dx[i][num-1]*go;
                       int ny = cam[0] + dy[i][num-1]*go;
                       go++;
                       if(nx<1 || ny<1 || nx>M || ny>N || temp[ny][nx]!=0 && temp[ny][nx]!=-1) break;
                       if(temp[ny][nx]!=-1) {
                           sum++;
                           temp[ny][nx]=-1;
                       }

                   }


               }
               index++;
           }
           if(max<sum)
           {
               max = sum;
           }

           return;

        }

        for(int i=1;i<=4;i++)
        {
           stack.push(i);
           recur(cnt-1,stack);
           stack.pop();

        }

    }
}
