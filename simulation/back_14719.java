package simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class back_14719 {
    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int H = Integer.parseInt(st.nextToken());
       int W = Integer.parseInt(st.nextToken());
       int[][] map = new int[H+1][W+1];
        st = new StringTokenizer(br.readLine());
       for(int i = 1; i <= W; i++)
       {
            int h = Integer.parseInt(st.nextToken());
            for(int j = H; j>H-h; j--)
            {
                map[j][i] = 1;
            }
       }
       boolean wall=false;
       int count=0;
       int result=0;
       for(int i = H; i>=1; i--)
       {
           for(int j = 1; j<=W; j++)
           {
               if(map[i][j] == 1 && !wall)
               {
                   wall=true;
               }else if(map[i][j] == 1 && wall)
               {

                   if(count>0)
                   {
                       result+=count;
                       count=0;
                   }

               }else if(map[i][j] == 0 && wall)
               {
                   if(j==W)
                   {
                       count=0;
                       break;
                   }
                   count++;
               }
           }

           wall=false;
       }
       System.out.println(result);
    }


}
